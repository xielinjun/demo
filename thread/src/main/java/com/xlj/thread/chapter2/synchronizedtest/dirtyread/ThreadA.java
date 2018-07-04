package com.xlj.thread.chapter2.synchronizedtest.dirtyread;

public class ThreadA extends Thread {

    PublicVar publicVar;

    public ThreadA(PublicVar publicVar)
    {
        this.publicVar = publicVar;
    }

    @Override
    public void run() {

        this.publicVar.setValue("b", "bb");

    }
}
