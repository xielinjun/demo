package com.xlj.thread.chapter1.interrupt;

public class RunMyThread {

    public static void main(String[] args) {
        MyThread thread = new MyThread();

        System.out.println("is stop -3? = " + thread.isInterrupted());
        System.out.println("is stop -2? = " + thread.isInterrupted());
        System.out.println("end! " + thread.getState());
        System.out.println();

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

//        Thread.currentThread().interrupt();

        System.out.println("is stop 1? = " + thread.isInterrupted());
        System.out.println("is stop 2? = " + thread.isInterrupted());
        System.out.println("end! " + thread.getState());
        System.out.println();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("is stop 3? = " + thread.isInterrupted());
        System.out.println("is stop 4? = " + thread.isInterrupted());
        System.out.println("end! " + thread.getState());
        thread.start();

    }

}
