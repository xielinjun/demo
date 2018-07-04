package com.xlj.thread.chapter2.synchronizedtest.dirtyread;

public class Run {

    public static void main(String[] args) {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (publicVar)
        {
            System.out.println("main synchronized.");
        }

        publicVar.getValue();
    }

}
