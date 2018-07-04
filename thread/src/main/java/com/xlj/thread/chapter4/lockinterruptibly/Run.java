package com.xlj.thread.chapter4.lockinterruptibly;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();
//        threadB.interrupt();

        System.out.println("main end");

    }

}
