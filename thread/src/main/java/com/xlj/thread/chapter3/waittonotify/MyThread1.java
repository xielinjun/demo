package com.xlj.thread.chapter3.waittonotify;

public class MyThread1 extends Thread {

    Object lock;

    public MyThread1(Object lock)
    {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (this.lock)
        {
            System.out.println("begin wait time = " + System.currentTimeMillis());

            try {
                this.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end wait time = " + System.currentTimeMillis());
        }

    }
}
