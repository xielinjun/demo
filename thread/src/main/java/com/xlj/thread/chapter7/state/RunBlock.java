package com.xlj.thread.chapter7.state;

public class RunBlock {

    public synchronized static void testMethod()
    {
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Thread a = new Thread(){
            @Override
            public void run() {
                RunBlock.testMethod();
            }
        };

        Thread b = new Thread(){
            @Override
            public void run() {
                RunBlock.testMethod();
            }
        };

        Thread c = new Thread(){
            @Override
            public void run() {
                RunBlock.testMethod();
            }
        };

        a.start();
        b.start();
        c.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getState());
        System.out.println(b.getState());
        System.out.println(c.getState());

    }

}
