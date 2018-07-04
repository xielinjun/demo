package com.xlj.thread.chapter2.synchronizedtest.exceptiontest;

public class Service {


    public synchronized void testMethod()
    {
        if(Thread.currentThread().getName().equals("a"))
        {
            System.out.println("thread name = "
                    + Thread.currentThread().getName()
                    + " run begintime = " + System.currentTimeMillis());

            int i = 1;
            while (i == 1)
            {
                if(("" + Math.random()).substring(0, 8).equals("0.123456"))
                {
                    System.out.println("thread name = "
                            + Thread.currentThread().getName()
                            + " run exceptiontime = " + System.currentTimeMillis());

                    Integer.parseInt("a");
                }
            }
        }
        else
        {
            System.out.println("thread b run time = " + System.currentTimeMillis());
        }
    }

}
