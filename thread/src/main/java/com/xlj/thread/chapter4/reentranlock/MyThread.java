package com.xlj.thread.chapter4.reentranlock;

public class MyThread extends Thread {

    MyService myService;

    public MyThread(MyService myService)
    {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
