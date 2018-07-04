package com.xlj.thread.chapter2.synchronizedtest.synchronizedrandom;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List list = new ArrayList();

    public synchronized void add(String username)
    {
        System.out.println("thread = " + Thread.currentThread().getName() + "in add method.");
        this.list.add(username);
        System.out.println("thread = " + Thread.currentThread().getName() + " out add method.");
    }

    public synchronized int getSize()
    {
        System.out.println("thread = " + Thread.currentThread().getName() + "in add method.");
        int size = this.list.size();
        System.out.println("thread = " + Thread.currentThread().getName() + " out add method.");
        return size;
    }

}
