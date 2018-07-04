package com.xlj.thread.chapter6.serial;

import java.io.Serializable;

public class MyObject implements Serializable {
    private static final long serialVersionUID = -3252276551011616679L;

    public MyObject my;

    public MyObject getMy() {
        return my;
    }

    public void setMy(MyObject my) {
        this.my = my;
    }
    //    private static final long serialVersionUID = -603521889292114479L;

    private MyObject()
    {

    }


    public Object readResolve()
    {
        System.out.println("readResolve");
        return MyObjectHandler.myObject;
    }

    public static MyObject getInstance()
    {
        return MyObjectHandler.myObject;
    }

    private static class MyObjectHandler
    {
        private static final MyObject myObject = new MyObject();
    }

}
