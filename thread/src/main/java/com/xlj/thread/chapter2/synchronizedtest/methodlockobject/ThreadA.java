package com.xlj.thread.chapter2.synchronizedtest.methodlockobject;

public class ThreadA extends Thread {

    private MyObject object;

    public ThreadA(MyObject object)
    {
        this.object = object;
    }

    @Override
    public void run() {
        this.object.methodA();
    }
}
