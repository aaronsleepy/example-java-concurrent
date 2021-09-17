package org.socurites.ex.concurrent.basic;

/**
 * 2개의 값을 더하기
 * - result = t1.f + t2.g
 */
public class RunnableBasicEx {
    public static void main(String[] args) throws InterruptedException {
        RunnableBasicEx ex = new RunnableBasicEx();
        ex.execute();
    }

    private void execute() throws InterruptedException {
        int x = 1337;
        Result result = new Result();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 started");
                result.left = f(x);
                System.out.println("t1 ended");
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 started");
            result.right = g(x);
            System.out.println("t2 ended");
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        int sum = result.left + result.right;
        System.out.println(String.format("Sum = %d", sum));
    }

    private int f(int x) {
        System.out.println("Calculating massive calculation by f");
        return x;
    }

    private int g(int x) {
        System.out.println("Calculating massive calculation by g");
        return x;
    }

    private static class Result {
        private int left;
        private int right;
    }
}
