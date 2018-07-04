package com.xlj.thread.chapter7.multiexception;

public class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("static's exception process.");
//        e.printStackTrace();
        System.out.println();
    }
}
