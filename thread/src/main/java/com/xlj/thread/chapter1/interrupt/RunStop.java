package com.xlj.thread.chapter1.interrupt;

public class RunStop {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;

                while (true)
                {
                    i++;
                    System.out.println("i = " + i + " " + Thread.currentThread().getState());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        try {
            thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end!" + thread.getState());
        thread.stop();

        System.out.println("end!" + thread.getState());
        thread.stop();

        System.out.println("end!");
    }

}
