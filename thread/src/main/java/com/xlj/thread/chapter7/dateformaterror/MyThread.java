package com.xlj.thread.chapter7.dateformaterror;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    SimpleDateFormat simpleDateFormat;
    String dateString;

    public MyThread(String dateString)
    {
        this.dateString = dateString;
    }

    @Override
    public void run() {

        try {
            this.simpleDateFormat = DateTools.getSimpleDateFormat();
            Date date = simpleDateFormat.parse(dateString);

            String newDateString = simpleDateFormat.format(date).toString();

            if (!newDateString.equals(dateString)) {
                System.out.println("thread name = " + this.getName() + " error: " +
                        this.dateString + " -> " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
