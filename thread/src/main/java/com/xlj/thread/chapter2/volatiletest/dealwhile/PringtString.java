package com.xlj.thread.chapter2.volatiletest.dealwhile;

public class PringtString implements Runnable {

    boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMehtod()
    {
        System.out.println("in");

        while (this.isContinuePrint)
        {
//            System.out.println("run printStringMethod threadName = " + Thread.currentThread().getName());

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        System.out.println("out");
    }

    @Override
    public void run() {
        this.printStringMehtod();
    }
}
