package com.xlj.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class MasterSelector {

    CuratorFramework curatorFramework = null;
    String serverAddress = "127.0.0.1:2181";
    int sessionTimeOut = 5 * 1000;
    String masterPath = "/masterselector/master";
    PathChildrenCache pathChildrenCache = null;
    String masterName = "";
    byte[] datas = null;

    public MasterGettedNotify getMasterGettedNotify() {
        return masterGettedNotify;
    }

    public void setMasterGettedNotify(MasterGettedNotify masterGettedNotify) {
        this.masterGettedNotify = masterGettedNotify;
    }

    MasterGettedNotify masterGettedNotify = null;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(int sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }

    public String getMasterPath() {
        return masterPath;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public byte[] getDatas() {
        return datas;
    }

    public void setDatas(byte[] datas) {
        this.datas = datas;
    }

    /**
     *获取一个 curatorFramework 实例
     * @return
     */
    private void initCuratorFramework()
    {
        this.curatorFramework = CuratorFrameworkFactory.builder().
                connectString(this.serverAddress).
                sessionTimeoutMs(this.sessionTimeOut).
                retryPolicy(new ExponentialBackoffRetry(1000 * 5, 3 )).
                connectionTimeoutMs(this.sessionTimeOut).build();

        this.curatorFramework.start();
    }

    /**
     *
     * @throws Exception
     */
    public MasterSelector() throws Exception {

        this.initCuratorFramework();
        this.initPathChildrenCache();
    }

    /**
     * 初始化事件监听器
     * @throws Exception
     */
    private void initPathChildrenCache() throws Exception {

        final MasterSelector masterSelector = this;

        String rootPath = this.getRootPath();
        this.pathChildrenCache = new PathChildrenCache(this.curatorFramework,
                rootPath, false);
        this.pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
        this.pathChildrenCache.getListenable().addListener(
                new PathChildrenCacheListener() {
                    @Override
                    public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
//                        System.out.println("收到事件: " + event.getType() + " ->" + new String(masterSelector.datas));

                        if(event.getType() == PathChildrenCacheEvent.Type.CHILD_REMOVED)
                        {
                            if(masterSelector.createMaster())
                            {
                                masterSelector.doProcess();
                            }
                        }
                    }
                }
        );
    }

    /**
     * 获取 master
     * @throws Exception
     */
    public void getMaster() throws Exception {
        this.createRoot();

        if(!this.checkMasterIsExists())
        {
            if(this.createMaster())
            {
                this.doProcess();
            }
        }
    }

    /**
     * 创建根节点
     * @throws Exception
     */
    private void createRoot() throws Exception {

        String rootPath = this.getRootPath();

        Stat stat = this.curatorFramework.checkExists().forPath(rootPath);
        if(stat == null)
        {
            this.curatorFramework.create().forPath(rootPath, "root".getBytes());
        }
    }

    /**
     * 获取根节点路径
     * @return
     */
    private String getRootPath()
    {
        return this.masterPath.substring(0,
            this.masterPath.substring(1).indexOf('/') + 1);
    }

    /**
     * 校验 master 是否存在
     * @return
     * @throws Exception
     */
    private boolean checkMasterIsExists() throws Exception {
        boolean result = false;

        Stat stat = this.curatorFramework.checkExists().forPath(this.masterPath);
        if(stat != null)
        {
            System.out.println("master 已经存在: " +
                    new String(this.curatorFramework.getData().forPath(this.masterPath))
                    + " 当前 master: " + new String(this.datas));
            result = true;
        }

        return result;
    }

    /**
     * 执行回调通知
     */
    private void doProcess()
    {
        if(this.masterGettedNotify != null)
        {
            this.masterGettedNotify.process();
        }
    }

    /**
     * 创建 master 创建成功就是 master
     * @return
     */
    private boolean createMaster()
    {
        boolean result = false;

        try {
            String path = this.curatorFramework.create().
                    withMode(CreateMode.EPHEMERAL).
                    forPath(this.masterPath, this.datas);

            System.out.println("创建 master 成功,并获取 master 权限: " + new String(this.datas));
//            System.out.println("------------------------------------");
//            System.out.println();

            result = true;
        } catch (Exception e) {
//            System.out.println("");
            System.out.println("获取 master 失败: " + new String(this.datas));
//            e.printStackTrace();
        }

        return result;
    }

    /**
     * 释放 master
     * @throws Exception
     */
    public void releaseMaster() throws Exception {
        if(this.curatorFramework.checkExists().forPath(this.masterPath) != null) {

            String data = new String(this.curatorFramework.getData().forPath(this.masterPath));

            if (new String(this.datas).equals(data)) {
                this.curatorFramework.delete().forPath(this.masterPath);

                System.out.println("释放当前 master: " + data);
                System.out.println("------------------------------------");
                System.out.println();
            }
        }
    }
}