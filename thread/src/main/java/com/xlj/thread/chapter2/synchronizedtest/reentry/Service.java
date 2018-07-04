package com.xlj.thread.chapter2.synchronizedtest.reentry;

public class Service {

    public synchronized void service1()
    {
        System.out.println("service1");
        this.service2();
    }

    public synchronized void service2()
    {
        System.out.println("service2");
        this.service3();
    }

    public synchronized void service3()
    {
        System.out.println("service3");
    }

}
