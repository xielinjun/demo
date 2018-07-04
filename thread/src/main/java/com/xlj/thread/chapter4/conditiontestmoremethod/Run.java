package com.xlj.thread.chapter4.conditiontestmoremethod;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadAA aa = new ThreadAA(service);
        aa.setName("AA");

        a.start();
        aa.start();
//
//        try {
//            Thread.sleep(1000 * 5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ThreadB b = new ThreadB(service);
        b.setName("B");
        ThreadBB bb = new ThreadBB(service);
        bb.setName("BB");

        b.start();
        bb.start();

    }

}
