package com.xlj.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Start {

    static CuratorFramework curatorFramework;
    static String basePath = "/xlj_curator";

    static NodeCache nodeCache = null;
    static PathChildrenCache pathChildrenCache = null;
    static TreeCache treeCache = null;

    public static void main(String[] args) throws Exception {

        List<MasterSelector> listMasterSelector = new ArrayList<MasterSelector>();
        List<Thread> threads = new ArrayList<Thread>();
        int nCount = 10;

        for(int i = 0 ; i < nCount; i++)
        {
            final MasterSelector masterSelector = new MasterSelector();
            masterSelector.setDatas(("master: " + i).getBytes());
            listMasterSelector.add(masterSelector);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        masterSelector.getMaster();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            threads.add(thread);
        }

        for(int i=0 ; i < threads.size(); i++)
        {
            threads.get(i).start();;
        }

        TimeUnit.SECONDS.sleep(5);

        //模拟循环释放锁
        while (true) {
            for (int i = 0; i < listMasterSelector.size(); i++) {
                listMasterSelector.get(i).releaseMaster();
            }

            TimeUnit.SECONDS.sleep(5);
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

    public static void TestDefaultOperation() throws Exception
    {
        curatorFramework = getCuratorFramework();
        //节点数据修改
        nodeCache = new NodeCache(curatorFramework, basePath);
        nodeCache.start(true);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("++++++++++++++++++++++++++++++++");
                System.out.println("node cache:" + nodeCache.getCurrentData().getPath()
                        + " " + nodeCache.getCurrentData().getData());
                System.out.println("++++++++++++++++++++++++++++++++");
            }
        });

        //路径改变
        pathChildrenCache = new PathChildrenCache(curatorFramework, basePath, true);
        pathChildrenCache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework,
                                   PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("?????????????????????????????????");
                System.out.println("path cache:" + nodeCache.getCurrentData().getPath()
                        + " " + nodeCache.getCurrentData().getData()
                        + " " + pathChildrenCacheEvent.getType());
                System.out.println("?????????????????????????????????");
            }
        });

        //节点 or 路径 改变
        treeCache = new TreeCache(curatorFramework, basePath);
        treeCache.start();
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework client,
                                   TreeCacheEvent event) throws Exception {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("path cache:" + nodeCache.getCurrentData().getPath()
                        + " " + nodeCache.getCurrentData().getData()
                        + " " + nodeCache
                        + " " + event.getType());
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        });


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

        try
        {
            System.out.println("create synchronized: " + "->" + Thread.currentThread().getName());
            curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                    System.out.println("synchronized result: " + event.getPath()
                            + "->" + Thread.currentThread().getName());
                    System.out.println("----------------------------");
                }
            }).forPath(basePath + "/xlj_curator_persistent_asynchronized", "123".getBytes());

            System.out.println("create synchronized:" + "->" + Thread.currentThread().getName());
            ExecutorService service = Executors.newFixedThreadPool(1);
            curatorFramework.create().creatingParentsIfNeeded().inBackground(new BackgroundCallback() {
                @Override
                public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                    System.out.println("synchronized result: " + event.getPath()
                            + "->" + Thread.currentThread().getName());
                    System.out.println("----------------------------");
                }
            }, service).forPath(basePath + "/xlj_curator_persistent_synchronized", "123".getBytes());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            System.out.println("in transaction:");

            Collection<CuratorTransactionResult> results =
                    curatorFramework.inTransaction().create().withMode(CreateMode.PERSISTENT).
                            forPath(basePath + "/xlj_curator_persistent_synchronized_intrans",
                                    "234".getBytes()).and().setData().
                            forPath(basePath + "/xlj_curator_persistent_synchronized_intrans",
                                    "345".getBytes()).and().commit();

            for(CuratorTransactionResult result:results)
            {
                System.out.println("result: " +
                        result.getForPath() + " " +
                        result.getResultPath() + " " +
                        result.getResultStat() + " " +
                        result.getType());
            }

            System.out.println("----------------------------");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}