package com.xlj.thread.chapter7.state;

public class RunGroup {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

        ThreadGroup tg = new ThreadGroup("xlj thread group.");

        Thread thread = new Thread(tg, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread1 = new Thread(tg, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(tg, new Runnable() {
            @Override
            public void run() {

            }
        });

        thread.start();
        thread1.start();
        thread2.start();

//        tg.setDaemon(true);
//        tg.interrupt();

        System.out.println(thread.getState() + " " + thread1.getState() + " " + thread2.getState() + " ");

        System.out.println(tg.activeCount() + " " + tg.activeGroupCount() + " " + tg.getMaxPriority() + " " + tg.getParent().getName());

        System.out.println();
        System.out.println();


        Thread[] ts = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(ts, false);

        System.out.println(ts.length);

        for(int i = 0; i < ts.length; i++)
        {

            if(ts[i] == null)
            {
                continue;
            }

            System.out.println(ts[i].getName());
        }



    }
}
