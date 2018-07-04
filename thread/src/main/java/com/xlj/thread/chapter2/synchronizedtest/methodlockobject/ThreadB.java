package com.xlj.thread.chapter2.synchronizedtest.methodlockobject;

public class ThreadB extends Thread {

    MyObject object = new MyObject();

    public ThreadB(MyObject object)
    {
        this.object = object;
    }

    @Override
    public void run() {
        this.object.methodB();
    }
}
