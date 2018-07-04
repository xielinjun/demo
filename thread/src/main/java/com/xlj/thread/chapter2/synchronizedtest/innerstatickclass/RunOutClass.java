package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class RunOutClass {

    public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        inner.method1();
                    }
                }
        , "a");

        Thread t2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        inner.methode2();
                    }
                }
        , "b");

        t1.start();
        t2.start();
    }

}
