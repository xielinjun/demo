package com.xlj.thread;

public class CallableFutur implements java.util.concurrent.Callable<Integer> {

    @Override
    public Integer call() {

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
