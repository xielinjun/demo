package com.xlj.thread.chapter4.uninterruptibly;

public class MyThread extends Thread {

    Service service;

    public MyThread(Service service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.testMethod();
    }
}
