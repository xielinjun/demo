package com.xlj.thread.chapter3.waittonotify;

public class ThreadA extends Thread {

    Object lock;

    public ThreadA(Object lock)
    {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock)
        {
            System.out.println(MyList.size() + " " + (MyList.size() % 5));

            if(MyList.size() == 0 || MyList.size() % 5 != 0)
            {
                try {
                    System.out.println("begin wait notify." + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("end wait recieve notifyed." + Thread.currentThread().getName());

                    Thread.sleep(1000 * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
