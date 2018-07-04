package com.xlj.thread.chapter4.readreadshare;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read()
    {
        lock.readLock().lock();

        System.out.println("get read share lock " + Thread.currentThread().getName() + " "
            + System.currentTimeMillis());

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("releas read share lock " + Thread.currentThread().getName() + " "
                + System.currentTimeMillis());

        lock.readLock().unlock();
    }

    public void write()
    {
        this.lock.writeLock().lock();

        System.out.println("get write share lock " + Thread.currentThread().getName() + " "
                + System.currentTimeMillis());

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("releas write share lock " + Thread.currentThread().getName() + " "
                + System.currentTimeMillis());

        this.lock.writeLock().unlock();
    }

}
