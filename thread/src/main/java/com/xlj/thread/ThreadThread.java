package com.xlj.thread;

public class ThreadThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("thread run: " + this.getName());

        try {
            Thread.dumpStack();

            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread stop: " + this.getName());

    }
}
