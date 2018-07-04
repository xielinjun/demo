package com.xlj.thread.chapter2.synchronizedtest;

import java.util.Date;

public class Run {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(numRef);
        ThreadB threadB = new ThreadB(numRef);

        threadA.start();
        threadB.start();

    }
}