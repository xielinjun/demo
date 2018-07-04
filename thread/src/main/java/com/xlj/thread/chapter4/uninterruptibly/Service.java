package com.xlj.thread.chapter4.uninterruptibly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {


    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void testMethod()
    {
        this.lock.lock();

        System.out.println("wait begin");

        condition.awaitUninterruptibly();

        System.out.println("wait end");

        this.lock.unlock();
    }

}
