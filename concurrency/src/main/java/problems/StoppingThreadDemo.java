package problems;


public class StoppingThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        threadPoolTimeOutDemo();
    }

    private static void threadPoolTimeOutDemo() throws InterruptedException {

        Thread th1 = new Thread(() -> {
            while (true) {
                System.out.println("I am processing...");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Stopping task is requested");
                    return;
                }
            }
        });

        th1.start();
        Thread.sleep(10000);
        th1.interrupt();
        Thread.sleep(1000);

    }

    private class MyTask implements Runnable {
        public volatile boolean keepRunning = true;

        @Override
        public void run() {
            while (keepRunning) {

            }
        }
    }

    private void usingVolatile() {
        MyTask task = new MyTask();
        Thread t1 = new Thread(task);
        t1.start();

//        ---
        task.keepRunning = false;
    }
}
