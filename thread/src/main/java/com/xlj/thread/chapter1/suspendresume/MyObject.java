package com.xlj.thread.chapter1.suspendresume;

public class MyObject {

    private String username = "1";
    private String password = "11";

    public void setValue(String u, String p)
    {
        this.username = u;
        if(Thread.currentThread().getName().equals("a"))
        {
            System.out.println("suspend a thread !");
            Thread.currentThread().suspend();
        }

        this.password = p;
    }

    public void printAll()
    {
        System.out.println("username = " + this.username);
        System.out.println("password = " + this.password);
    }

}
