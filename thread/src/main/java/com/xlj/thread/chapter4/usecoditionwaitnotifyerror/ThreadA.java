package com.xlj.thread.chapter4.usecoditionwaitnotifyerror;

public class ThreadA extends Thread {

    MyService service;

    public ThreadA(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        service.await_A();
    }



}
