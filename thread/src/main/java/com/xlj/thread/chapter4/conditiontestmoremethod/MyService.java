package com.xlj.thread.chapter4.conditiontestmoremethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    Lock lock = new ReentrantLock();
    Lock lock1 = new ReentrantLock();

    public void methodA()
    {
        lock.lock();

        System.out.println("methodA begin threadname = " + Thread.currentThread().getName()
            + " time = " + System.currentTimeMillis());

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodA end threadname = " + Thread.currentThread().getName()
            + " time = " + System.currentTimeMillis());

        lock.unlock();
    }

    public void methodB()
    {
        lock.lock();

        System.out.println("methodB begin threadname = " + Thread.currentThread().getName()
                + " time = " + System.currentTimeMillis());

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("methodB end threadname = " + Thread.currentThread().getName()
                + " time = " + System.currentTimeMillis());

        lock.unlock();
    }

}
