package com.xlj.thread.chapter4.conditiontestmoremethod;

public class ThreadAA extends Thread {

    MyService service;

    public ThreadAA(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.methodA();
    }
}
