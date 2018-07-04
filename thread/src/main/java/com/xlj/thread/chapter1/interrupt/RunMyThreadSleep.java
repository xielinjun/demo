package com.xlj.thread.chapter1.interrupt;

public class RunMyThreadSleep {

    public static void main(String[] args) {
        MyThreadSleep myThreadSleep = new MyThreadSleep();

        myThreadSleep.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThreadSleep.interrupt();


    }

}
