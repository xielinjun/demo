package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class OutClass {

    static class Inner
    {
        public void method1()
        {
            synchronized ("otherlock")
            {
                for(int i = 0; i <= 10; i++)
                {
                    System.out.println(Thread.currentThread().getName() + " i = " + i);

                    try
                    {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void methode2()
        {
            for (int i = 11; i < 20; i++) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);

                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}