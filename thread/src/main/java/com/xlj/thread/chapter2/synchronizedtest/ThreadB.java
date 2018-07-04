package com.xlj.thread.chapter2.synchronizedtest;

public class ThreadB extends Thread {

    private HasSelfPrivateNum numRef = new HasSelfPrivateNum();

    public ThreadB(HasSelfPrivateNum numRef)
    {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("b");
    }
}
