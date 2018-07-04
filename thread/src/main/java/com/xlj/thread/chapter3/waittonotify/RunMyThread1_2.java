package com.xlj.thread.chapter3.waittonotify;

public class RunMyThread1_2 {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        ThreadA a1 = new ThreadA(lock);
        ThreadA a2 = new ThreadA(lock);
        ThreadA a3 = new ThreadA(lock);
        ThreadA a4 = new ThreadA(lock);
        ThreadA a5 = new ThreadA(lock);
        ThreadA a6 = new ThreadA(lock);

        ThreadB b = new ThreadB(lock);

        a.setName("a");
        a1.setName("a1");
        a2.setName("a2");
        a3.setName("a3");
        a4.setName("a4");
        a5.setName("a5");
        a6.setName("a6");

        a.start();
        a1.start();
        a2.start();
        a3.start();

        lock = new Object();

        a4.start();
        a5.start();
        a6.start();


//        a.interrupt();
//        a1.interrupt();
//        a2.interrupt();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        b.start();
//        System.out.println(a.getState() + " " + Thread.currentThread().getState());
//
//
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                synchronized (lock)
//                {
//                    try {
//                        lock.wait(100000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread.start();
//
//        try {
//            Thread.sleep(1000 * 30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(thread.getState());
    }

}
