package com.xlj.thread.chapter4.waituntil;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void waitMethod()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);

        lock.lock();

        System.out.println("wait bgein " + System.currentTimeMillis() + " " + calendar.getTime());
        try {
            condition.awaitUntil(calendar.getTime());
//            condition.awaitUntil();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("wait end " + System.currentTimeMillis());

        lock.unlock();
    }

    public void notifyMethod()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        lock.lock();
        System.out.println("botify begin " + System.currentTimeMillis());

        condition.signalAll();

        System.out.println("botify end " + System.currentTimeMillis());

        lock.unlock();
    }

}
