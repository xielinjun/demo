package com.xlj.thread.chapter3.nowaittonotify;

public class ThreadB extends Thread {

    MyList list;

    public ThreadB(MyList list)
    {
        this.list = list;
    }

    @Override
    public void run() {
        while(true)
        {
            if(this.list.size() % 5 == 0)
            {
                System.out.println("== " + this.list.size() + ", thread b will be exit.");
            }
        }
    }
}
