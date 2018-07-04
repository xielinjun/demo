package com.xlj.thread.chapter3.pipe;

public class DBTools {

    private boolean prevIsA = false;

    public synchronized void backupA()
    {
        while (this.prevIsA)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("AAAAAAAAA");

        this.prevIsA = true;
        this.notifyAll();
    }

    public synchronized void backupB()
    {
        while (!this.prevIsA)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("BBBBBBBBBB");

        this.prevIsA = false;
        this.notifyAll();
    }

}
