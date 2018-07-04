package com.xlj.thread.chapter2.synchronizedtest.twoobjectlock;


public class Run {

    public static void main(String[] args) {
        HasSelfPrivateNum num1 = new HasSelfPrivateNum();
        HasSelfPrivateNum num2 = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(num1);
        ThreadB threadB = new ThreadB(num2);

        threadA.start();
        threadB.start();
    }

}
