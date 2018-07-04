package com.xlj.thread.chapter1.stop;

public class MyThread extends Thread {

    private SynchronizedObject object;

    public MyThread(SynchronizedObject object)
    {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }
}
