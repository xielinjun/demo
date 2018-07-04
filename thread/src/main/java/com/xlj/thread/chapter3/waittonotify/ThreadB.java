package com.xlj.thread.chapter3.waittonotify;

public class ThreadB extends Thread {

    Object lock;

    public ThreadB(Object lock)
    {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (this.lock)
        {
            for (int i = 0; i < 5; i++)
            {
                MyList.add();

                System.out.println("added " + (i + 1) + " items.");

                if(MyList.size() % 5 == 0)
                {
                    lock.notifyAll();
                    System.out.println("notify is sended.");
                }

                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
