package com.xlj.thread;

import com.xlj.thread.chapter4.fair.Children;

public class SychronizedTest {

    protected synchronized void test1()
    {
//        Children children = new Children();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("test1 end");
    }

    protected synchronized void test2()
    {

        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("test2 end");
    }


    public static void main(String[] args)
    {
        SychronizedTest sychronizedTest = new SychronizedTest();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sychronizedTest.test1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sychronizedTest.test2();
            }
        });

        thread.start();
        thread2.start();
    }
}
