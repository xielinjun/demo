package com.xlj.thread.chapter3.nowaittonotify;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    List<String> list = new ArrayList<>();
     int size = 0;

    public void add()
    {
        list.add("xlj");
        this.size = list.size();
    }

    public int size()
    {
        return this.size;
    }

}
