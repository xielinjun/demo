package com.xlj.thread.chapter1.priority;

public class RunMyThread3_4 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread3 myThread3 = new MyThread3();
            MyThread4 myThread4 = new MyThread4();

            myThread3.setPriority(5);
            myThread4.setPriority(6);

            myThread3.start();
            myThread4.start();
        }
    }

}
