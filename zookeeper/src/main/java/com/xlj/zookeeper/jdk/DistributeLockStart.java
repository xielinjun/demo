package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DistributeLockStart {

    public  static  void main(String[] args) throws IOException, KeeperException, InterruptedException {
        List<DistributeLock> listLock = new ArrayList<DistributeLock>();
        List<Thread> threads = new ArrayList<Thread>();
        int count = 1;
        for(int i = 0; i < count; i++)
        {
            final int index = i;
            final DistributeLock distributeLock = new DistributeLock();
            listLock.add(distributeLock);

            listLock.get(i).processer = new DistributeLockProcesser() {
                @Override
                public void process() {
                    System.out.println("处理事物: " + index + " ->" + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        distributeLock.getLock();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.setName("thread: " + index);

            threads.add(thread);
        }

        for(int i = 0; i < count; i++)
        {
            threads.get(i).start();
        }

        System.in.read();
    }
}