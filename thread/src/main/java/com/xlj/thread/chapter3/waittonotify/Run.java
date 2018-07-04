package com.xlj.thread.chapter3.waittonotify;

public class Run {

    public static void main(String[] args) {
        Object lock = new Object();

        MyThread1 thread1 = new MyThread1(lock);
        MyThread2 thread2 = new MyThread2(lock);

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.start();
        thread2.start();
    }

}
