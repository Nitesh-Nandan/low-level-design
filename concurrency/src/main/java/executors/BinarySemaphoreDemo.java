package executors;

import java.util.concurrent.Semaphore;

class BinarySemaphore {

    Semaphore semaphore = new Semaphore(1);

    public void print() throws InterruptedException {
        System.out.println(semaphore.availablePermits());
        semaphore.acquire();
        System.out.println(semaphore.availablePermits());
        Thread.sleep(10000);
        System.out.println(semaphore.availablePermits());
        System.out.println("Printed by ddd");
        semaphore.release();
    }

    public void print2() throws InterruptedException {
        Thread.sleep(500);
        semaphore.release();
        Thread.sleep(5000);
        System.out.println("Printed by mmmmm");
    }

}
public class BinarySemaphoreDemo {
    public static void main(String[] args) {
        BinarySemaphore bs = new BinarySemaphore();

        new Thread(() -> {
            try {
                bs.print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                bs.print2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
