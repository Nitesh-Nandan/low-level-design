package executors;

public class RecursiveLockDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                recursiveLock(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                recursiveLock(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void recursiveLock(int count) throws InterruptedException {
        synchronized (lock) {
            System.out.println("Thread " + Thread.currentThread().getId() + " acquired the lock");

            // Perform some work...

            // Recursive locking
            if (count > 0) {
                recursiveLock(count - 1);
            } else {
                // Simulate some condition to release the lock
                lock.notify();
            }

            // Simulate waiting for another condition
            lock.wait();
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " released the lock");
    }
}
