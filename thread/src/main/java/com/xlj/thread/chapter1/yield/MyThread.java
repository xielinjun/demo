package com.xlj.thread.chapter1.yield;

public class MyThread extends Thread {

    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
//            Thread.yield();
            count += (i + 1);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("use time: " + (endTime - beginTime) + " ms");

    }
}
