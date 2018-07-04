package com.xlj.thread.chapter2.synchronizedtest;

public class HasSelfPrivateNum {

    private int num = 0;

    public synchronized void addI(String username)
    {
        if(username.equals("a"))
        {
            System.out.println("a set over.");
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {
            num = 200;
            System.out.println("b set over.");
        }

        System.out.println(username + " " + num);
    }

}
