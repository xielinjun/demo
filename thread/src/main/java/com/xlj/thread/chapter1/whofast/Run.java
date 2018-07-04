package com.xlj.thread.chapter1.whofast;

public class Run {
    static int nCount1 = 0;
    static int nCount2 = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(){
            @Override
            public void run() {

                while (true)
                {
                    nCount1++;
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {

                while (true)
                {
                    nCount2++;
                }
            }
        };

        thread1.setPriority(Thread.NORM_PRIORITY - 3);
        thread2.setPriority(Thread.NORM_PRIORITY + 3);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.stop();
        thread2.stop();

        System.out.println("count1 = " + nCount1 + " count2 = " + nCount2);
    }

}
