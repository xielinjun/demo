package com.xlj.thread.chapter3.threadlocal;

public class RunThreadA_B {

    public static void main(String[] args) {
        Tools.it1.set("Main Value.");

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        for (int i = 0; i < 100; i++)
        {
            Tools.t1.set("Main t1 " + (i + 1));
            Tools.t2.set("Main t2 " + (i + 1));

            System.out.println("Main t1 get = " + Tools.t1.get());
            System.out.println("Main t2 get = " + Tools.t2.get());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tools.it1.get() = " + Tools.it1.get());
    }

    static class MyThreadLocal extends ThreadLocal
    {
        @Override
        protected Object initialValue() {
            return "first";
        }
    }

}
