package com.xlj.thread.chapter3.productorstack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private static List list = new ArrayList();

    public static void push()
    {
        MyStack.list.add("xlj");
    }

    public static void pop()
    {
        MyStack.list.remove(0);
    }

    public static int size()
    {
        return MyStack.list.size();
    }

}
