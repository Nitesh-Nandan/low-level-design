package basics;

class UserThread implements Runnable {
    @Override
    public void run() {

    }
}

class UserThreadExtendingThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

public class RunnableThreadDemo {
    public static void main(String[] args) throws InterruptedException {

    }
}
