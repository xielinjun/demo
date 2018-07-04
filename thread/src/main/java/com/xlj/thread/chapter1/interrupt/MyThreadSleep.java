package com.xlj.thread.chapter1.interrupt;

public class MyThreadSleep extends Thread {

    @Override
    public void run() {

        try {
            for(int i = 0; i < 500000; i++)
            {
                System.out.println("i = " + (i + 1));
            }

            System.out.println("run begin");

            Thread.sleep(1000 * 200);

            System.out.println("run end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
