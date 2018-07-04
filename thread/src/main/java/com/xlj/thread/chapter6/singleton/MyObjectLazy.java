package com.xlj.thread.chapter6.singleton;

public class MyObjectLazy {

    private static MyObjectLazy myObject = null;


    public static MyObjectLazy getInstance()
    {
        if (MyObjectLazy.myObject == null)
        {
            synchronized (MyObjectLazy.class)
            {
                if (MyObjectLazy.myObject == null) {

                    try {
                        Thread.sleep(1000 * 3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    MyObjectLazy.myObject = new MyObjectLazy();
                }
            }
        }

        return MyObjectLazy.myObject;
    }

}