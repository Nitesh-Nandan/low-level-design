package problems;

class DeadLockProgram {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    public void task1() {
        while (true) {
            synchronized (lock1) {
                System.out.println("Lock 1 is acquired for task1");
                synchronized (lock2) {
                    System.out.println("Lock 2 is acquired for task1");
                }
            }
        }

    }

    public void task2() {
        while (true) {
            synchronized (lock2) {
                System.out.println("Lock 2 is acquired for task2");
                synchronized (lock1) {
                    System.out.println("Lock 1 is acquired for task2");
                }
            }
        }

    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLockProgram program = new DeadLockProgram();
        new Thread(program::task1).start();
        new Thread(program::task2).start();
    }
}
