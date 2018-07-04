package com.xlj.thread.chapter3.threadlocal;

public class ThreadB extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadB Tools.it1.get() = " + Tools.it1.get());

        for(int i = 0; i < 100; i++)
        {
            Tools.t1.set("ThreadB " + (i + 1));

            System.out.println("ThreadB get = " + Tools.t1.get());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
