package org.socurites.ex.concurrent.pool;

import java.util.concurrent.*;

/**
 * {@link org.socurites.ex.concurrent.basic.CallableBasicEx}를 ExecutorService를 사용하도록 개선
 */
public class ExecutorServiceEx {
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorServiceEx ex = new ExecutorServiceEx();
        ex.execute();
    }

    private void execute() throws ExecutionException, InterruptedException {
        int x = 1337;
        Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("t1 started");
                Integer result = f(x);
                System.out.println("t1 ended");
                return result;
            }
        });

        Future<Integer> future2 = executorService.submit(() -> {
            System.out.println("t2 started");
            Integer result = g(x);
            System.out.println("t2 ended");
            return result;
        });

        int sum = future1.get().intValue() + future2.get().intValue();

        System.out.println(String.format("Sum = %d", sum));

        executorService.shutdown();
    }

    private Integer f(int x) {
        System.out.println("Calculating massive calculation by f");
        return Integer.valueOf(x);
    }

    private Integer g(int x) {
        System.out.println("Calculating massive calculation by g");
        return Integer.valueOf(x);
    }
}
