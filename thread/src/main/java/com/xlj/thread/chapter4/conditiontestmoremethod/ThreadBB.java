package com.xlj.thread.chapter4.conditiontestmoremethod;

public class ThreadBB extends Thread {

    MyService service;

    public ThreadBB(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.methodB();
    }
}
