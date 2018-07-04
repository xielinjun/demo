package com.xlj.thread.chapter7.multiexception;

public class MyThreadGorup extends ThreadGroup {
    public MyThreadGorup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);

//        System.out.println("threa group's exception process.");
////        e.printStackTrace();
//        System.out.println();
    }
}
