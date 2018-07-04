package com.xlj.thread.chapter1.isalive;

public class Run {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
        System.out.println("end == " + myThread.isAlive());

    }

}