package com.xlj.thread.chapter1.isalive;

public class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println("run = " + this.isAlive());

    }
}
