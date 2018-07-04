package com.xlj.thread.chapter2.synchronizedtest.methodlockobject;

public class Run {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA threadA = new ThreadA(object);
        ThreadB threadB = new ThreadB(object);

        threadA.setName("Thread A");
        threadB.setName("Thread B");

        threadA.start();
        threadB.start();

    }

}
