package com.xlj.thread.chapter1.isalive;

public class Run2 {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            MyThread2 myThread2 = new MyThread2();
            System.out.println("begin = " + System.currentTimeMillis());

            myThread2.start();

            System.out.println("end = " + System.currentTimeMillis());

            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
