package com.xlj.thread.chapter4.fair;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Run {

    public static void main(String[] args) {
        new Children();


        Service service = new Service(true);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("* thread " + Thread.currentThread().getName() + " is running.");
                service.serviceMethod();
            }
        };

        java.util.List<Thread> listThread = new ArrayList();

        for (int i = 0; i < 100; i++)
        {
            listThread.add(new Thread(runnable));
            listThread.get(i).start();
        }

        for (int i = 0; i < listThread.size(); i++)
        {
            System.out.println(
                    "i = " + i + " " + ((ReentrantLock)service.lock).hasQueuedThread(listThread.get(i))
                            + " " + ((ReentrantLock)service.lock).hasQueuedThreads()
                            + " " + ((ReentrantLock)service.lock).isFair()
                            + " " + ((ReentrantLock)service.lock).isHeldByCurrentThread());

        }


    }
}
