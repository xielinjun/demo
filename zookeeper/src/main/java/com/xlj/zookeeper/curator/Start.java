package com.xlj.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class Start {

    static CuratorFramework curatorFramework;
    static String basePath = "/xlj_curator";

    public static void main(String[] args) throws Exception {

        curatorFramework = getCuratorFramework();

        try {
            System.out.println("delete for parent:");
            //删除
            curatorFramework.delete().deletingChildrenIfNeeded().forPath(basePath);
            System.out.println("----------------------------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            System.out.println("create of parent:");
            //创建
            String resultCreate = curatorFramework.create().
                    creatingParentsIfNeeded().
                    withMode(CreateMode.PERSISTENT).
                    forPath(basePath + "/xlj_curator_persistent",
                            "xlj_curator_persistent".getBytes());
            System.out.println("create: " + resultCreate);
            System.out.println("----------------------------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            System.out.println("get data:");
            //获取数据
            byte[] resultGetData = curatorFramework.getData().forPath(basePath + "/xlj_curator_persistent");
            System.out.println(new String(resultGetData));
            System.out.println("----------------------------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            System.out.println("get data and states:");
            Stat stat = new Stat();
            //获取数据和状态
            byte[] resultGetData = curatorFramework.getData().
                    storingStatIn(stat).forPath(basePath + "/xlj_curator_persistent");
            System.out.println(new String(resultGetData));
            System.out.println(stat);
            System.out.println("----------------------------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            System.out.println("set data:");
            Stat stat = null;
            //获取数据和状态
            stat = curatorFramework.setData().
                    forPath(basePath + "/xlj_curator_persistent", "123".getBytes());
            System.out.println(stat);
            //获取数据和状态
            byte[] resultGetData = curatorFramework.getData().
                    storingStatIn(stat).forPath(basePath + "/xlj_curator_persistent");
            System.out.println(new String(resultGetData));
            System.out.println("----------------------------");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 工厂形式返回
     * @return
     */
    public static CuratorFramework getCuratorFramework()
    {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.newClient("127.0.0.1:2181",
                        5 * 1000,
                        5 * 1000,
                        new ExponentialBackoffRetry(1000, 3 ));

        curatorFramework.start();

        return curatorFramework;
    }

    /**
     * fluent形式返回
     * @return
     */
    public static CuratorFramework getCuratorFrameworkFromFluent()
    {
        CuratorFramework curatorFramework =
                CuratorFrameworkFactory.builder().
                        connectString("127.0.0.1:2181").
                        sessionTimeoutMs(5 * 1000).
                        connectionTimeoutMs(5 * 1000).
                        retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        curatorFramework.start();

        return curatorFramework;
    }
}