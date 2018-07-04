package com.xlj.thread.chapter1.stop;

public class Run {

    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        MyThread thread = new MyThread(object);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getState());
        thread.stop();
        System.out.println(thread.getState());
        System.out.println(object.getUsername() + " " + object.getPassword());

        while (thread.getState() != Thread.State.TERMINATED)
        {
            System.out.println(thread.getState());
        }
    }

}