package com.xlj.thread;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable thread: " + Thread.currentThread().getName());
    }
}
