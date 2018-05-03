package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * zookeeper 分布式锁
 */
public class DistributeLock {

    public static final String LOCKROOTPATH = "/distributloockroot";
    String currentID;
    String serverAddress = "127.0.0.1:2181";
    int seesionTimeOut = 5 * 1000;
    ZooKeeper zooKeeper = null;
    DistributeLockProcesser processer;

    public String getCurrentID() {
        return currentID;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getSeesionTimeOut() {
        return seesionTimeOut;
    }

    public void setSeesionTimeOut(int seesionTimeOut) {
        this.seesionTimeOut = seesionTimeOut;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public void setZooKeeper(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    DistributeLockWatcher distributeLockWatcher = new DistributeLockWatcher() {

        DistributeLock distributeLock;

        @Override
        public DistributeLock getDistributeLock() {
            return distributeLock;
        }

        @Override
        public void setDistributeLock(DistributeLock distributeLock) {

            this.distributeLock = distributeLock;
        }

        @Override
        public void process(WatchedEvent event) {
            Event.EventType type= event.getType();
            Event.KeeperState state = event.getState();
            String path = event.getPath();

//            System.out.println("收到事件: " + state + " " + type + " " + path
//                    + " ->" + Thread.currentThread().getName());

            //如果是链接中
            if(state == Event.KeeperState.SyncConnected)
            {
                switch (type)
                {
                    case NodeDeleted:
                        try {
                            if (this.getDistributeLock().checkCurrentIsFirst()) {
                                this.getDistributeLock().doProcess();
                            }
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;

                    case NodeCreated:
//                        System.out.println("NodeCreated");
                        break;

                    case NodeDataChanged:
//                        System.out.println("NodeDataChanged");
                        break;

                    case NodeChildrenChanged:
//                        System.out.println("NodeChildrenChanged");
                        break;

                    case None:
//                        System.out.println("None");
                        break;
                }

                try {
                    if(path != null) {
                        //判断节点是否存在
                        Stat stat = this.getDistributeLock().getZooKeeper().
                                exists(DistributeLock.LOCKROOTPATH, true);
                        this.getDistributeLock().getZooKeeper().
                                getData(DistributeLock.LOCKROOTPATH, true, stat);
                        this.getDistributeLock().getZooKeeper().
                                getChildren(DistributeLock.LOCKROOTPATH, true, stat);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            System.out.println("---------------------------------------------"
//                    + " ->" + Thread.currentThread().getName());
//            System.out.println();
        }
    };


    /**
     * constructor
     * @throws IOException
     */
    public DistributeLock() throws IOException {
        this.distributeLockWatcher.setDistributeLock(this);

        this.zooKeeper = new ZooKeeper(this.serverAddress,
                this.seesionTimeOut,
                this.distributeLockWatcher);
    }

    /**
     * 获取锁且执行
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void getLock() throws KeeperException, InterruptedException {

        this.createRoot();

        this.createCurrent();

        if(this.checkCurrentIsFirst()) {
            if (this.processer != null) {
                this.doProcess();
            }
        }
    }

    /**
     * 创建根节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    private void createRoot() throws KeeperException, InterruptedException {

        //判断节点是否存在
        Stat stat = this.zooKeeper.exists(DistributeLock.LOCKROOTPATH, true);

        //如果根节点不存在先要创建根节点
        if(stat == null) {
            try {
                String strResult = this.zooKeeper.create(DistributeLock.LOCKROOTPATH,
                        "lock root".getBytes(),
                        ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }

        this.zooKeeper.getData(DistributeLock.LOCKROOTPATH, true, stat);
        this.zooKeeper.getChildren(DistributeLock.LOCKROOTPATH, true, stat);
    }

    /**
     * 创建自己
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void createCurrent() throws KeeperException, InterruptedException {

//        System.out.println("开始创建节点: " + this.currentID);

        this.currentID = this.zooKeeper.create(DistributeLock.LOCKROOTPATH + "/",
                "ephemeral".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);

        //判断节点是否存在
        Stat stat = this.zooKeeper.exists(DistributeLock.LOCKROOTPATH, true);
        this.zooKeeper.getData(DistributeLock.LOCKROOTPATH, true, stat);
        this.zooKeeper.getChildren(DistributeLock.LOCKROOTPATH, true, stat);

//        System.out.println("创建节点完成: " + this.currentID);
    }

    /**
     * 判断当前节点是否是整个队列的第一个节点
     */
    private boolean checkCurrentIsFirst() throws KeeperException, InterruptedException {

        System.out.println("当前节点:" + this.currentID
                + " ->" + Thread.currentThread().getName());

        boolean result = false;

        //获取根节点下所有子节点
        List<String> children = this.zooKeeper.getChildren(DistributeLock.LOCKROOTPATH, true);

        SortedSet<String> childrenSorted = new TreeSet<String>(children);

        //如果当前节点是第一个
        if(this.currentID.equals(DistributeLock.LOCKROOTPATH + "/" + childrenSorted.first()))
        {
            result = true;
            System.out.println("当前节点就是队列第一个:" + this.currentID
                    + " ->" + Thread.currentThread().getName());
        }
        else //如果当前节点不是队列的第一个, 就监听自己的上一个节点
        {
            String currentID = this.currentID.substring(this.currentID.lastIndexOf('/') + 1);
            SortedSet<String> pres = childrenSorted.headSet(currentID);
            zooKeeper.exists(DistributeLock.LOCKROOTPATH + "/" + pres.last(), true);

            System.out.println("当前节点不是队列第一个,添加上一个节点监听:" + DistributeLock.LOCKROOTPATH + "/" + pres.last()
                    + " ->" + Thread.currentThread().getName());

            System.out.println("---------------------------------------------"
                    + " ->" + Thread.currentThread().getName());
            System.out.println();
        }

        return result;
    }


    /**
     * 执行操作代码
     */
    private void doProcess() throws KeeperException, InterruptedException {

        System.out.println("开始执行任务: " + this.currentID
                + " ->" + Thread.currentThread().getName());
        this.processer.process();

        System.out.println("任务执行完成: " + this.currentID
                + " ->" + Thread.currentThread().getName());
        System.out.println("---------------------------------------------"
                + " ->" + Thread.currentThread().getName());
        System.out.println();


//        System.out.println("删除节点开始: " + this.currentID
//                + " ->" + Thread.currentThread().getName());

        this.zooKeeper.delete(this.currentID, -1);

//        System.out.println("删除节点完成: " + this.currentID
//                + " ->" + Thread.currentThread().getName());
    }

}