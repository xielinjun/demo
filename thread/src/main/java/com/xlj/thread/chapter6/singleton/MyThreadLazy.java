package com.xlj.thread.chapter6.singleton;

public class MyThreadLazy extends Thread {


    @Override
    public void run() {
        System.out.println(MyObjectLazy.getInstance().hashCode());
    }
}
