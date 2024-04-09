package basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;

class LockWithNormal {

    final Object lock = new Object();

    public void recursionLock(int x) {
        if (x == 0) {
            return;
        }
        synchronized (lock) {
            System.out.println("The value of x: " + x + "printed by: " + Thread.currentThread().getName());
            recursionLock(x - 1);
        }

    }
}

public class ReentrantLockDemo {

    private static void test1() {
        LockWithNormal normal = new LockWithNormal();

        Thread th1 = new Thread(() -> {
            normal.recursionLock(10);
        });

        Thread th2 = new Thread(() -> {
            normal.recursionLock(5);
        });

        th1.setName("Thread1");
        th2.setName("Thread2");

        th1.start();
        th2.start();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        functionalInterfaceDemo();
    }


    public static void functionalInterfaceDemo() throws ExecutionException, InterruptedException {

        LockWithNormal obj = new LockWithNormal();

        Callable<String> callable = () -> {
            Thread.sleep(10000);
            obj.recursionLock(10);
            return "Hello World";
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        System.out.println(System.currentTimeMillis());
        System.out.println(futureTask.get());
        System.out.println(System.currentTimeMillis());

        Runnable runnable = () -> {
            try {
                Thread.sleep(10000);
                obj.recursionLock(10);
                System.out.println("Hello World!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

    }
}
