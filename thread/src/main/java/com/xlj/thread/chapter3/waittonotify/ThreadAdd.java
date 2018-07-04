package com.xlj.thread.chapter3.waittonotify;

public class ThreadAdd extends Thread {

    private Add p;

    public ThreadAdd(Add p)
    {
        this.p = p;
    }

    @Override
    public void run() {

        p.add();

    }
}
