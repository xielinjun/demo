package com.xlj.thread.chapter3.waittonotify;

public class ThreadSubtract extends Thread {

    private Subtract r;

    public ThreadSubtract(Subtract r)
    {
        this.r = r;
    }

    @Override
    public void run() {
        this.r.subtrucat();
    }
}
