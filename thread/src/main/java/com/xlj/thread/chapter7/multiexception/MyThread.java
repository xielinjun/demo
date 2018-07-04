package com.xlj.thread.chapter7.multiexception;

public class MyThread extends Thread {

    String num = "a";

    public MyThread()
    {

    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(this.num);
        System.out.println("in thread print : " + (numInt + 1));
    }
}
