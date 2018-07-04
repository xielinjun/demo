package com.xlj.thread.chapter4.usecoditionwaitnotifyerror;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.signalAll_A();

    }
}
