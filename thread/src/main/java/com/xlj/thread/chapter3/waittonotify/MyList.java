package com.xlj.thread.chapter3.waittonotify;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    public static List list = new ArrayList();

    public static void add()
    {
        list.add("xlj");
    }

    public static int size()
    {
        return list.size();
    }

}
