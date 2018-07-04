package com.xlj.thread.chapter4.usecoditionwaitnotifyerror;

public class ThreadB extends Thread {

    MyService service;

    public ThreadB(MyService service)
    {
        this.service = service;
    }

    @Override
    public void run() {
        service.await_B();
    }



}
