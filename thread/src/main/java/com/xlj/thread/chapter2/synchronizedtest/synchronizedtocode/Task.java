package com.xlj.thread.chapter2.synchronizedtest.synchronizedtocode;

public class Task {

    String getData1;
    String getData2;

    public void doLongTimeTask()
    {
        System.out.println("begin task.");

        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            getData1 = "long time return 1 thread name = " + Thread.currentThread().getName();
            getData2 = "long time return 2 thread name = " + Thread.currentThread().getName();
        }

        System.out.println(getData1);
        System.out.println(getData2);
        System.out.println("end task.");

    }

}
