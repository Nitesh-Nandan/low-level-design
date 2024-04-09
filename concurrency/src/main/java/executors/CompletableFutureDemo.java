package executors;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPools = Executors.newFixedThreadPool(5);
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10 + 20;
        }, threadPools).thenApplyAsync(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10 * x;
        }, threadPools) .thenAccept(System.out::println);

        System.out.println("Hello Word");
        Thread.sleep(10000);
        System.out.println("Done");
    }

}
