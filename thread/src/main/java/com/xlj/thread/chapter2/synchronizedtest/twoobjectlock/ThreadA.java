package com.xlj.thread.chapter2.synchronizedtest.twoobjectlock;


public class ThreadA extends Thread {

    private HasSelfPrivateNum numRef;


    public ThreadA(HasSelfPrivateNum numRef)
    {
        this.numRef = numRef;
    }

    @Override
    public void run() {
        numRef.addI("a");
    }
}
