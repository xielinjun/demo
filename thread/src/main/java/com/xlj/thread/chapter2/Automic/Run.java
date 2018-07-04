package com.xlj.thread.chapter2.Automic;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        List<Thread> listThreads = new ArrayList<>();

        MyService myService = new MyService();

        for (int i = 0; i < 100; i++)
        {
            listThreads.add(new Thread(){
                @Override
                public void run() {
                    myService.addNum();
                }
            });
        }

        for (int i = 0; i < listThreads.size(); i++)
        {
            listThreads.get(i).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myService.aiRef.get());
    }
}
