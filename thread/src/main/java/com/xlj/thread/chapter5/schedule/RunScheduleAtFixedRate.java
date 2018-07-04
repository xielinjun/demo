package com.xlj.thread.chapter5.schedule;

import java.math.BigInteger;
import java.util.*;

public class RunScheduleAtFixedRate {

    public static void main(String[] args) {

        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                System.out.println("begin timer=" + new Date());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("--------------------end timer=" + new Date());
                System.out.println();
            }
        };


        System.out.println("main begin " + new Date());
        System.out.println();


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -20);
        Date runDate = calendar.getTime();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(tt, 3000, 2000);


//        TestClass testClass = "ddddddd";
//        TestClass.valueOf()

//        BigInteger.probablePrime()


//        EnumSet.of()
//        ServiceLoader.load()

//        Collections.ge

    }

    static class TestClass
    {
        public TestClass(int n, String string)
        {

        }

        public TestClass(String string, int n)
        {

        }

        public static TestClass valueOf(String str)
        {
            return null;
        }
    }

}
