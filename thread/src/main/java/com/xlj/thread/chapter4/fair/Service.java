package com.xlj.thread.chapter4.fair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    Lock lock;
    Condition condition;

    public Service(boolean isFair)
    {
        this.lock = new ReentrantLock(isFair);
        condition = lock.newCondition();
    }

    public void serviceMethod()
    {
        this.lock.lock();
        this.lock.lock();
        this.lock.lock();
        this.lock.lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread " + Thread.currentThread().getName() + " get lock. " +
                ((ReentrantLock)this.lock).getHoldCount()
                + " getQueueLength:" + ((ReentrantLock)this.lock).getQueueLength()
                + " getWaitQueueLength:" + ((ReentrantLock)this.lock).getWaitQueueLength(condition)
                + " isHeldByCurrentThread:" + ((ReentrantLock)this.lock).isHeldByCurrentThread());


//        this.serviceMethod1();

        this.lock.unlock();
        this.lock.unlock();
        this.lock.unlock();
        this.lock.unlock();
    }

    public void serviceMethod1()
    {
        this.lock.lock();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread " + Thread.currentThread().getName() + " get lock. serviceMethod1" +
                ((ReentrantLock)this.lock).getHoldCount());

        this.lock.unlock();
    }

}
