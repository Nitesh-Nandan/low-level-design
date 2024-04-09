package problems;

import java.util.function.Predicate;

class WriterProgram {

    final Object lock = new Object();
    private final Integer limit;
    private volatile int counter = 0;

    public WriterProgram(int limit) {
        this.limit = limit;
        this.counter = 0;
    }

    public void writer(Predicate<Integer> predicate) throws InterruptedException {
        while (counter < limit) {
            synchronized (lock) {
                while (!predicate.test(counter)) {
                    lock.wait();
                }
                System.out.println("Printed by " + Thread.currentThread().getName() + " is " + counter);
                counter += 1;
                lock.notifyAll();
            }
        }

    }
}

public class OddEvenWriter {

    public static void main(String[] args) {
        Predicate<Integer> evenPredicate = val -> val % 3 == 0;
        Predicate<Integer> oddPredicate = val -> val % 3 == 1;
        Predicate<Integer> otherPredicate = val -> val % 3 == 2;

        WriterProgram writerProgram = new WriterProgram(50);

        new Thread(() -> {
            try {
                writerProgram.writer(evenPredicate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "One Thread").start();

        new Thread(() -> {
            try {
                writerProgram.writer(oddPredicate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Second Thread").start();

        new Thread(() -> {
            try {
                writerProgram.writer(otherPredicate);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Third Thread").start();
    }
}
