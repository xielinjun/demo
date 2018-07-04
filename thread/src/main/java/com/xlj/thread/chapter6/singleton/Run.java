package com.xlj.thread.chapter6.singleton;

public class Run {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread.start();
        myThread1.start();
        myThread2.start();

        MyThreadLazy myThreadLazy = new MyThreadLazy();
        MyThreadLazy myThreadLazy1 = new MyThreadLazy();
        MyThreadLazy myThreadLazy2 = new MyThreadLazy();

        myThreadLazy.start();
        myThreadLazy1.start();
        myThreadLazy2.start();


        for (int i = 0; i < 10; i++) {

            new Thread(){
                @Override
                public void run() {
                    System.out.println(MyObjectInner.getInstance().hashCode());
                }
            }.start();
        }

    }
}