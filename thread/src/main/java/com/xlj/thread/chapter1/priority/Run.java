package com.xlj.thread.chapter1.priority;

public class Run {

    public static void main(String[] args) {
        System.out.println("main thread begin priority = " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);

        System.out.println("main thread end priority = " + Thread.currentThread().getPriority());

        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("main end!");
    }

}
