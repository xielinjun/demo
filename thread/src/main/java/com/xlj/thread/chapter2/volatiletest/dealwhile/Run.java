package com.xlj.thread.chapter2.volatiletest.dealwhile;

public class Run {

    public static void main(String[] args) {
        PringtString pringtString = new PringtString();

        new Thread(pringtString).start();

        System.out.println("i will stop it. stop Thread = " + Thread.currentThread().getName());

        pringtString.setContinuePrint(false);
    }

}
