package com.xlj.thread.chapter4.conditiontestmoremethod;

public class ThreadB extends Thread {

    MyService service;

    public ThreadB(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.methodB();
    }
}
