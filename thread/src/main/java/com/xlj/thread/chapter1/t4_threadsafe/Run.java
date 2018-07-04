package com.xlj.thread.chapter1.t4_threadsafe;

public class Run {

    public static void main(String[] args)
    {
        ALogin a = new ALogin();
        BLogin b = new BLogin();

        a.start();
        b.start();
    }

}
