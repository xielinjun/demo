package com.xlj.thread.chapter1.daemon;

public class Run {

    public static void main(String[] args) {

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (true)
                {
                    i++;
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread1.setDaemon(true);
        thread1.start();

        System.out.println(thread1.getState());

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("i am will leave.");
    }

}
