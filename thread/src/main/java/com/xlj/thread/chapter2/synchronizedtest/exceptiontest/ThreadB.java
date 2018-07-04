package com.xlj.thread.chapter2.synchronizedtest.exceptiontest;

public class ThreadB extends Thread {

    Service service;

    public ThreadB(Service service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.testMethod();
    }
}
