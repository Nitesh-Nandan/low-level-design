package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockQueueUsingLock<E> {
    private final int limit;
    private final Queue<E> queue;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BlockQueueUsingLock(int limit) {
        this.limit = limit;
        queue = new LinkedList<>();
    }

    public BlockQueueUsingLock() {
        this(5);
    }

    public void enqueue(E record) {
        lock.lock();
        try {
            while (queue.size() == limit) {
                notFull.await();
            }
            queue.offer(record);
            System.out.println("Enqueue Record " + record);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public E deque() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            E record = queue.poll();
            System.out.println("Deque Record " + record);
            notFull.signalAll();
            return record;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

public class BlockingQueueDemoWithLock {
    public static void main(String[] args) {
        BlockQueueUsingLock<String> mq = new BlockQueueUsingLock<>();
        Runnable producer = () -> {
            while (true) {
                mq.enqueue(generateRandomString());
            }

        };

        Runnable consumer = () -> {
            while (true) {
                mq.deque();
            }
        };


        Thread p1 = new Thread(producer);
        Thread p2 = new Thread(producer);
        Thread p3 = new Thread(producer);

        Thread c1 = new Thread(consumer);
        Thread c2 = new Thread(consumer);

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }


    private static String generateRandomString() {
        return UUID.randomUUID().toString();
    }
}
