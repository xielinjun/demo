package com.xlj.thread.chapter2.synchronizedtest.dirtyread;

public class PublicVar {

    public String username = "a";
    public String password = "aa";

    public synchronized void setValue(String uaername, String password)
    {
        this.username = uaername;
        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.password = password;

        System.out.println("setvalue method thread name = "
                + Thread.currentThread().getName()
                + " username = " + this.username
                + " password = " + this.password);
    }

    public synchronized void getValue()
    {
        System.out.println("getvalue method thread name = "
                + Thread.currentThread().getName()
                + " username = " + this.username
                + " password = " + this.password);
    }

}
