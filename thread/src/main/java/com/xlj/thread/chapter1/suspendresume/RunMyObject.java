package com.xlj.thread.chapter1.suspendresume;

public class RunMyObject {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            }
        };
        thread1.setName("a");
        thread1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                myObject.printAll();
            }
        };
        thread2.start();
    }

}
