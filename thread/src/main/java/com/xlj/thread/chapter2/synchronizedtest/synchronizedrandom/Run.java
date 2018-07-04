package com.xlj.thread.chapter2.synchronizedtest.synchronizedrandom;

public class Run {

    public static void main(String[] args) {
        MyList list = new MyList();

        Thread a = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++)
                {
                    list.add("a " + i );
                }
            }
        };

        Thread b = new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++)
                {
                    list.add("b " + i );
                }
            }
        };

        a.setName("a");
        b.setName("b");

        a.start();
        b.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String e = new StringBuilder().append("dd").append("d").toString();
        System.out.println(e.intern() == e);

        String d = new String("ddd");
        System.out.println(d.intern() == d);


    }

}
