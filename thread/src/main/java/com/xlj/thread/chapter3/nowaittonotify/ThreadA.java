package com.xlj.thread.chapter3.nowaittonotify;

public class ThreadA extends Thread {

    MyList list;

    public ThreadA(MyList list)
    {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            this.list.add();
            System.out.println("add " + (i + 1) + " items." + this.list.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
