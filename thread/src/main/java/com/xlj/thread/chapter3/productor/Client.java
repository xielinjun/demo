package com.xlj.thread.chapter3.productor;

public class Client {

    private String lock;

    public Client(String lock)
    {
        this.lock = lock;
    }

    public void getVlaue()
    {
        synchronized (this.lock)
        {
            while (Productor.value.equals(""))
            {
                System.out.println("wait productor prudoct." + Thread.currentThread().getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            System.out.println("client consume = " + Productor.value + " " + Thread.currentThread().getName());
            Productor.value = "";
            lock.notifyAll();
        }
    }
}
