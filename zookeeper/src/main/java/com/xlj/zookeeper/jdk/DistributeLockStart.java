package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁测试
 */
public class DistributeLockStart {

    public  static  void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //所有要抢锁的对象
        List<DistributeLock> listLock = new ArrayList<DistributeLock>();
        //模拟抢锁执行的线程
        List<Thread> threads = new ArrayList<Thread>();

        //模拟抢锁的数量
        int count = 10;
        for(int i = 0; i < count; i++)
        {
            final int index = i;
            final DistributeLock distributeLock = new DistributeLock();
            listLock.add(distributeLock);

            //设置每个wacther
            listLock.get(i).processer = new DistributeLockProcesser() {
                @Override
                public void process() {
                    System.out.println("模拟处理事务ing: " + index + "........ ->" + Thread.currentThread().getName());
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            //执行线程
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
            //设置线程的名字,方便输出时候跟踪执行过程
            thread.setName("thread: " + index);

            threads.add(thread);
        }

        //执行抢锁
        for(int i = 0; i < count; i++)
        {
            threads.get(i).start();
        }

        System.in.read();
    }
}