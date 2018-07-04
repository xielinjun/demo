package com.xlj.thread.chapter4.conditiontestmoremethod;

public class ThreadA extends Thread {

    MyService service;

    public ThreadA(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.methodA();
    }
}
