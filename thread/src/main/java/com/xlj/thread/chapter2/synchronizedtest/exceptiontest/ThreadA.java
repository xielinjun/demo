package com.xlj.thread.chapter2.synchronizedtest.exceptiontest;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service)
    {
        this.service = service;
    }

    @Override
    public void run() {

        this.service.testMethod();

    }
}
