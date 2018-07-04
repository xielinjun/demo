package com.xlj.thread.chapter1.suspendresume;

public class RunSynchronizedObject {

    public static void main(String[] args) {
        SynchronizedObject object =  new SynchronizedObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                object.printString();
            }
        };
        thread1.setName("a");
        thread1.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println("thread two only print begin.");
                object.printString();
                System.out.println("thread two end.");
            }
        };

        thread2.start();

        Thread thread3 = new Thread(){
            @Override
            public void run() {

                int i = 0;

                while (true)
                {
                    i++;
                    System.out.println(i);
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };

        thread3.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println("main end1.");

//        System.out.println("main end 1.");
        thread3.suspend();

        System.out.println("main end 2.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end 3.");
    }
}
