package com.xlj.thread.chapter3.waittonotify;

public class Subtract {

    String lock;

    public Subtract(String lock)
    {
        this.lock = lock;
    }

    public void subtrucat()
    {
        synchronized (this.lock)
        {
            while (ValueObject.list.size() == 0)
            {
                System.out.println("wait begin threadname = " + Thread.currentThread().getName());

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("wait end threadname = " + Thread.currentThread().getName());
            }

            ValueObject.list.remove(0);
            System.out.println("list size = " + ValueObject.list.size());
        }
    }

}
