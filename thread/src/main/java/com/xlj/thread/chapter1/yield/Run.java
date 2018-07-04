package com.xlj.thread.chapter1.yield;

public class Run {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();
    }

}
