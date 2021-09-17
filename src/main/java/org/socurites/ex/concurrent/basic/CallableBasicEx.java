package org.socurites.ex.concurrent.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableBasicEx {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableBasicEx ex = new CallableBasicEx();
        ex.execute();
    }

    private void execute() throws InterruptedException, ExecutionException {
        int x = 1337;

        FutureTask<Integer> futureTask1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("t1 started");
                Integer result = f(x);
                System.out.println("t1 ended");
                return result;
            }
        });
        Thread t1 = new Thread(futureTask1);

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println("t2 started");
            Integer result = g(x);
            System.out.println("t2 ended");
            return result;
        });
        Thread t2 = new Thread(futureTask2);

        t1.start(); t2.start();
        t1.join(); t2.join();

        int sum = futureTask1.get().intValue() + futureTask2.get().intValue();

        System.out.println(String.format("Sum = %d", sum));
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
