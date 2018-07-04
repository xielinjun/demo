package com.xlj.thread.chapter1.isalive;

public class MyThread2 extends Thread {

    @Override
    public void run() {
        System.out.println("run threadname = " + this.getName() + " begin = " + System.currentTimeMillis());
        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run threadname = " + this.getName() + " end = " + System.currentTimeMillis());
    }
}
