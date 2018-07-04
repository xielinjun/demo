package com.xlj.thread.chapter1.returninterrupt;

public class MyThread extends Thread {

    @Override
    public void run() {

        while (true)
        {
            if(this.isInterrupted())
            {
                System.out.println("MyThread end!");
                return;
            }

            System.out.println("timer = " + System.currentTimeMillis());
        }

    }
}
