package com.xlj.thread.chapter2.synchronizedtest.reentry;

public class Run {

    public static void main(String[] args) {

        Thread thread = new Thread(){
            @Override
            public void run() {

                new Service().service1();

            }
        };

        thread.start();

    }

}
