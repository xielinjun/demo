package com.xlj.thread.chapter2.synchronizedtest.deallock;

public class Run {

    public static void main(String[] args) {
        DealThread dealThread = new DealThread();
        dealThread.setFlag("a");
        Thread thread1 = new Thread(dealThread);
        thread1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        dealThread.setFlag("b");
        Thread thread2 = new Thread(dealThread);
        thread2.start();
    }

}
