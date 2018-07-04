package com.xlj.thread.chapter3.productorstack;

public class Client {

    private Object lock;

    public Client(Object lock)
    {
        this.lock = lock;
    }

    public void consume()
    {
        synchronized (this.lock)
        {
            while (MyStack.size() == 0)
            {
                try {
                    this.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            MyStack.pop();
            this.lock.notifyAll();
            System.out.println("consume one item. " + Thread.currentThread().getName());

        }
    }

}
