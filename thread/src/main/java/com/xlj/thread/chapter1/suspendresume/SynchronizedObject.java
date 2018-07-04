package com.xlj.thread.chapter1.suspendresume;

public class SynchronizedObject {

    public synchronized void printString()
    {
        System.out.println("begin");

        if(Thread.currentThread().getName().equals("a"))
        {

            String str1 = new StringBuilder("dddd").toString();
            System.out.println(str1.intern() == str1);
            System.out.println(str1 == "dddd");
            str1 = "dddd";
            System.out.println(str1 == "dddd");
            String str = new StringBuilder("ddd").append("dddd").toString();
            System.out.println(str.intern() == str);
            System.out.println("ddddddd" == str);

            System.out.println("a thread is forever to suspend!");
            Thread.currentThread().suspend();
        }

    }
}
