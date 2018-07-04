package com.xlj.thread.chapter4.lockinterruptibly;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();


    public void waitMethod()
    {
        try {
            if(this.lock.tryLock(1, TimeUnit.SECONDS))
            {
                System.out.println("lock begin " + Thread.currentThread().getName());

                for(int i = 0; i < Integer.MAX_VALUE / 10; i++)
                {
                    String newString = new String();
                    Math.random();
                }

                System.out.println("lock end " + Thread.currentThread().getName());

                this.lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}