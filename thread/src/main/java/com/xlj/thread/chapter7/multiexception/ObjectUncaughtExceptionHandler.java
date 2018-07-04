package com.xlj.thread.chapter7.multiexception;

public class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {

        System.out.println("object's exception process.");
//        e.printStackTrace();
        System.out.println();
    }
}
