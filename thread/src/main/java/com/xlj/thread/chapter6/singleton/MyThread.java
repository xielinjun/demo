package com.xlj.thread.chapter6.singleton;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}
