package com.xlj.thread.chapter6.singleton;

public class MyObjectInner {

    private MyObjectInner()
    {

    }

    public static MyObjectInner getInstance()
    {
        return MyObjectInnerHandler.myObject;
    }

    private static class MyObjectInnerHandler
    {
        private static MyObjectInner myObject = new MyObjectInner();
    }

}
