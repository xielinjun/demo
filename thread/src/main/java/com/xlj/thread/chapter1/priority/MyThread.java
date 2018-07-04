package com.xlj.thread.chapter1.priority;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread run privority = " + this.getPriority());

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
