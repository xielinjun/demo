package com.xlj.thread.chapter4.waituntil;

public class Run {

    public static void main(String[] args) {
        Service service = new Service();

        new Thread(){
            @Override
            public void run() {
                service.waitMethod();
            }
        }.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        new Thread(){
//            @Override
//            public void run() {
//                service.notifyMethod();
//            }
//        }.start();
    }

}
