package com.xlj.thread.chapter5.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RunDate {

    public static void main(String[] args) {
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000 * 2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(new Date());
            }
        };

        Timer timer = new Timer();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);

        System.out.println("main : " + new Date());
        timer.schedule(tt, 2000, 5000);
    }
}
