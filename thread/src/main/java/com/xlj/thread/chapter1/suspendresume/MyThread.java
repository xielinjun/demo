package com.xlj.thread.chapter1.suspendresume;

public class MyThread extends Thread {

    public MyThread()
    {

    }

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {

        while (true)
        {
            i++;
        }
    }
}
