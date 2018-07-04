package com.xlj.thread.chapter4.conditiontest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    boolean hasValue = false;

    public void set()
    {
        lock.lock();

        while (hasValue)
        {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("print * product " + Thread.currentThread().getName());
        hasValue = true;
        condition.signalAll();

        lock.unlock();
    }

    public void get()
    {
        lock.lock();

        while (!hasValue)
        {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("print ---------- consume " + Thread.currentThread().getName());
        hasValue = false;
        condition.signalAll();

        lock.unlock();
    }
}