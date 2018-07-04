package com.xlj.thread.chapter4.usecoditionwaitnotifyerror;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();

    public void await()
    {
        lock.lock();

        try {

            System.out.println("await at = " + System.currentTimeMillis());

            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }

    public void signal()
    {
        lock.lock();

        System.out.println("signal at = " + System.currentTimeMillis());
        conditionA.signal();

        lock.unlock();
    }

    public void await_A()
    {
        lock.lock();

        System.out.println("begin await_A at " + System.currentTimeMillis() + " " + Thread.currentThread().getName()
                + " " + ((ReentrantLock)this.lock).getWaitQueueLength(this.conditionB));

        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end await_A at " + System.currentTimeMillis() + " " + Thread.currentThread().getName()
                + " " + ((ReentrantLock)this.lock).getWaitQueueLength(this.conditionB));

        lock.unlock();
    }

    public void await_B()
    {
        lock.lock();

        System.out.println("begin await_B at " + System.currentTimeMillis() + " " + Thread.currentThread().getName()
                + " " + ((ReentrantLock)this.lock).getWaitQueueLength(this.conditionB));

        try {
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end await_B at " + System.currentTimeMillis() + " " + Thread.currentThread().getName()
                + " " + ((ReentrantLock)this.lock).getWaitQueueLength(this.conditionB));

        lock.unlock();
    }

    public void signalAll_A()
    {
        lock.lock();

        System.out.println("signalall_a at " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        conditionA.signalAll();

        lock.unlock();
    }

    public void signalAll_B()
    {
        lock.lock();

        System.out.println("signalall_a at " + System.currentTimeMillis() + " " + Thread.currentThread().getName());
        conditionB.signalAll();

        lock.unlock();
    }

}
