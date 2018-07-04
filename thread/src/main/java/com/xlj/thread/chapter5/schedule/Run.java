package com.xlj.thread.chapter5.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Run {

    public static void main(String[] args) {

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.cancel();
                System.out.println("task be schedule, time is: " + System.currentTimeMillis());
            }
        };

        TimerTask tt1 = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                this.cancel();
                System.out.println("task 1 be schedule, time is: " + System.currentTimeMillis());
            }
        };

        TimerTask tt2 = new TimerTask() {
            @Override
            public void run() {
                while (true)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("task 2 be schedule, time is: " + System.currentTimeMillis());
                }
            }
        };

        TimerTask tt3 = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task 3 be schedule, time is: " + System.currentTimeMillis() + " " + new Date());
            }
        };

        Timer timer = new Timer(true);

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + 5);
//
//        timer.schedule(tt, calendar.getTime(), 1000);
//        timer.schedule(tt1, calendar.getTime(), 2000);
//        timer.schedule(tt2, calendar.getTime());
        timer.schedule(tt3, 1000, 10000);

        try {
            Thread.sleep(1000 * 20);

//            timer.cancel();

            Thread.sleep(1000 * 200000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
