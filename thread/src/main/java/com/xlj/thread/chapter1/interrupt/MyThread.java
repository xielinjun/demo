package com.xlj.thread.chapter1.interrupt;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {

                System.out.println("i = " + (i + 1));

                if (this.isInterrupted()) {
                    throw new InterruptedException();
                }
            }

            System.out.println("MyThread end!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
