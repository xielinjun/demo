package com.xlj.thread.chapter3.productorstack;

public class Productor {

    Object lock;

    public Productor(Object lock)
    {
        this.lock = lock;
    }

    public void product()
    {
        synchronized (this.lock)
        {
            while (MyStack.size() != 0)
            {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            MyStack.push();
            System.out.println("product one item. " + Thread.currentThread().getName());
            this.lock.notifyAll();
        }
    }

}
