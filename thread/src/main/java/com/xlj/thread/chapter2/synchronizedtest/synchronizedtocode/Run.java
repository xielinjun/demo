package com.xlj.thread.chapter2.synchronizedtest.synchronizedtocode;

public class Run {

    public static void main(String[] args) {
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        thread1.start();
        MyThread2 thread2 = new MyThread2(task);
        thread2.start();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if(CommonUtils.beginTime1 < CommonUtils.beginTime1)
        {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if(CommonUtils.endTime2 > CommonUtils.endTime1)
        {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("use time: " + ((endTime - beginTime) / 1000));

    }
}