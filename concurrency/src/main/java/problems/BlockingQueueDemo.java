package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

class MyBlockingQueue<E> {
    private final int limit;
    private final Queue<E> queue;

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public MyBlockingQueue() {
        this(5);
    }

    public synchronized void enqueue(E data) throws InterruptedException {
        while (this.queue.size() == limit) {
            wait();
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        this.queue.offer(data);
        System.out.println("Enque Data " + data);

    }

    public synchronized E deque() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        E record = queue.poll();
        System.out.println("Enque Data " + record);
        return record;
    }
}

public class BlockingQueueDemo {
    public static void main(String[] args) {
        MyBlockingQueue<String> mq = new MyBlockingQueue<>();
        Runnable producer = () -> {
            while (true) {
                try {
                    mq.enqueue(generateRandomString());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    mq.deque();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
