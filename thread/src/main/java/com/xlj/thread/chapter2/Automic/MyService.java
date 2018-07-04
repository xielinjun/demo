package com.xlj.thread.chapter2.Automic;

import java.util.concurrent.atomic.AtomicInteger;

public class MyService {

    public static AtomicInteger aiRef = new AtomicInteger();

    public void addNum()
    {
        System.out.println(Thread.currentThread().getName() + " added 100 value is: " + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }

}
