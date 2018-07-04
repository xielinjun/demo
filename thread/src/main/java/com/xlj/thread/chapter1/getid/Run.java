package com.xlj.thread.chapter1.getid;

public class Run {

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread.currentThread.getID() = " +
                        Thread.currentThread().getId());
                }
            });
            System.out.println(i + " " + thread.getId());
            thread.start();

            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
