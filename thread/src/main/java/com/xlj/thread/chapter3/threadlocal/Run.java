package com.xlj.thread.chapter3.threadlocal;

public class Run {

    public  static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        System.out.println(t1.get());
        t1.set("xlj");
        System.out.println(t1.get());
        System.out.println(t1.get());

    }

}
