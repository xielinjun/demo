package com.xlj.thread.chapter3.productor;

public class Productor {

    public static String value = "";

    String lock;

    public Productor(String lock)
    {
        this.lock = lock;
    }

    public void setValue()
    {
        synchronized (this.lock)
        {
            while (!Productor.value.equals(""))
            {
                System.out.println("wait client consume." + Thread.currentThread().getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println("product one = " + value + " " + Thread.currentThread().getName());

            Productor.value = value;
            lock.notifyAll();
        }
    }
}
