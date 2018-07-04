package com.xlj.thread.chapter4.reentranlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    Lock lock = new ReentrantLock();

    public void testMethod()
    {
        lock.lock();

        for (int i = 0; i < 5; i++) {
            System.out.println("thread name = " + Thread.currentThread().getName() + " " + (i + 1));
        }

        lock.unlock();
    }

}
