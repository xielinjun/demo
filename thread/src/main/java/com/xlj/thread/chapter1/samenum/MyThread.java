package com.xlj.thread.chapter1.samenum;

public class MyThread extends Thread {

    private int i = 5;

    @Override
    public void run() {

        System.out.println("i = " + (i--) + "\tthreadname: " + this.getName());

    }
}
