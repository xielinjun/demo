package com.xlj.thread.chapter4.reentranlock;

public class Run {

    public static void main(String[] args) {

        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);
        MyThread t4 = new MyThread(service);
        MyThread t5 = new MyThread(service);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}