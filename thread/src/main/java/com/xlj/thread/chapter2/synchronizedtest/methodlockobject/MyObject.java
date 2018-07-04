package com.xlj.thread.chapter2.synchronizedtest.methodlockobject;

public class MyObject {


    public synchronized void methodA()
    {
        System.out.println("begin methodA threadName = " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

    public synchronized void methodB()
    {
        System.out.println("begin methodB threadName = " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

}
