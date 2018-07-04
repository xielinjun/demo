package com.xlj.thread.chapter4.uninterruptibly;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Run {

    public static void main(String[] args) {

        Service service = new Service();
        MyThread myThread =  new MyThread(service);
        myThread.start();

        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt();

        service.lock.lock();
        service.condition.signalAll();
        service.lock.unlock();

        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        java.util.List<Thread> list = new ArrayList<>();
        for(int i = 0 ; i < 50; i++)
        {
            final int j = i;

            Thread thread = new Thread(){
                @Override
                public void run() {
                    while (true)
                    {
                        ((ConcurrentHashMap<String, String>) map).put(System.currentTimeMillis() + "", "");
                    }
                }
            };

            list.add(thread);
            thread.start();
        }

        new Thread(){

            @Override
            public void run() {
                while (true) {

                    int nR = 0;
                    int nB = 0;

                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i).getState() == State.RUNNABLE)
                        {
                            nR ++;
                        }
                        else
                        {
                            nB++;
                        }
                    }

                    System.out.println(nR + " " + nB + "----------------------------------------------" + map.size());

                    try {
                        Thread.sleep(1000 * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }
}
