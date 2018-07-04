package com.xlj.thread.chapter3.waittonotify;

public class MyThread2 extends Thread {

    Object lock;

    public MyThread2(Object lock)
    {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (this.lock)
        {
            System.out.println("begin notify time = " + System.currentTimeMillis());

            this.lock.notify();

            System.out.println("end notify time = " + System.currentTimeMillis());
        }

    }
}
