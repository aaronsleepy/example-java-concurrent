package org.socurites.ex.concurrent.pool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link ExecutorServiceEx}를 CompletableFuture를 사용하도록 개선
 */
public class CompletableFutureEx {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureEx ex = new CompletableFutureEx();
        ex.execute();
    }

    private void execute() throws ExecutionException, InterruptedException {
        int x = 1337;

        CompletableFuture<Integer> future1 = new CompletableFuture<>();
        CompletableFuture<Integer> future2 = new CompletableFuture<>();
        CompletableFuture<Integer> finalFuture = future1.thenCombine(future2, (a, b) -> a+ b);

        executorService.submit(() -> future1.complete(f(x)));
        executorService.submit(() -> future2.complete(g(x)));

        int sum = finalFuture.get();

        System.out.printf("Sum = %d%n", sum);

        executorService.shutdown();
    }

    private Integer f(int x) {
        System.out.println("Calculating massive calculation by f");
        return x;
    }

    private Integer g(int x) {
        System.out.println("Calculating massive calculation by g");
        return x;
    }
}
