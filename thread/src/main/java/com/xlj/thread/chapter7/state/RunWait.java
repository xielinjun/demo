package com.xlj.thread.chapter7.state;

public class RunWait extends Thread {

    @Override
    public void run() {
        System.out.println("begin run");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end run");
    }

    public static void main(String[] args) {
        RunWait runWait = new RunWait();

        System.out.println(runWait.getState());

        runWait.start();

        System.out.println(runWait.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(runWait.getState());
    }
}
