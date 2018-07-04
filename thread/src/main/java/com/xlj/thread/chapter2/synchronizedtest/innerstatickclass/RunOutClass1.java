package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class RunOutClass1 {

    public static void main(String[] args) {
        OutClass1.InnerClass1 in1 = new OutClass1.InnerClass1();
        OutClass1.InnerClass2 in2 = new OutClass1.InnerClass2();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method1(in2);
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                in1.method2();
            }
        }, "t1");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                in2.method1();
            }
        }, "t1");

        t1.start();
        t2.start();
        t3.start();

    }

}
