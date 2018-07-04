package com.xlj.thread.chapter1.priority;

import java.util.Random;

public class MyThread4 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;

        for(int j = 0; j < 10; j++)
        {
            for(int i = 0; i < 5000000; i++)
            {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("+++++ thread 4 use time = " + (endTime - beginTime) + " ms");

    }
}
