package com.xlj.thread.chapter7.dateformaterror;

import java.text.SimpleDateFormat;

public class Run {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String[] dateStringArray = new String[]{
                "2000-01-01",
                "2000-01-02",
                "2000-01-03",
                "2000-01-04",
                "2000-01-05",
                "2000-01-06",
                "2000-01-07",
                "2000-01-08",
                "2000-01-09",
                "2000-01-10",
        };

        MyThread[] threads = new MyThread[dateStringArray.length];

        for(int i = 0; i < dateStringArray.length; i++)
        {
            threads[i] = new MyThread(dateStringArray[i]);
            threads[i].setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {

                }
            });
        }

        for(int i = 0; i < dateStringArray.length; i++)
        {
            threads[i].start();
        }

//        Thread.currentThread().getThreadGroup()
    }

}
