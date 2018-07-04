package com.xlj.thread.chapter1.suspendresume;

public class Run {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myThread.suspend();

            System.out.println(i + " = " + System.currentTimeMillis()
                    + " i = " + myThread.getI());

            myThread.resume();
        }

    }
}
