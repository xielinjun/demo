package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class ZookeeperUtils {

    //链接字符串(192.168.0.1:2181,192.168.0.2:2181)
    private String connectionString = "";

    //当前操作的路径
    private String path = "";

    //创建时候写入的内容
    private byte[] data = null;

    //事件监听器
    private Watcher watcher = null;

    //当前 zookeeper
    private ZooKeeper zooKeeper = null;

    //链接超时时间
    private int timeOut = 60 * 1000;

    //权限(创建的需要该参数 该参数的 每一个对象中的 id 对象的 id值都需要经过 DigestAuthenticationProvider.generateDigest("user:pwd") 传入)
    private List<ACL> acls = null;

    //初始化 zookeeper 之后设置权限的时候使用
    private List<Id> ids = null;

    public List<ACL> getAcls() {
        return acls;
    }

    public ZookeeperUtils setAcls(List<ACL> acls) {
        this.acls = acls;
        return  this;
    }

    public static ZookeeperUtils getZookeeperUtils()
    {
        return new ZookeeperUtils();
    }

    public ZookeeperUtils setConnectionString(String connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    public ZookeeperUtils setPath(String path) {
        this.path = path;
        return this;
    }

    public ZookeeperUtils setData(byte[] data) {
        this.data = data;
        return this;
    }

    public ZookeeperUtils setWatcher(Watcher watcher) {
        this.watcher = watcher;
        return this;
    }

    public List<Id> getIds() {
        return ids;
    }

    public ZookeeperUtils setIds(List<Id> ids) {
        this.ids = ids;
        return  this;
    }

    public ZookeeperUtils doInitZookeeper() throws IOException {
        this.zooKeeper = new ZooKeeper(this.connectionString, this.timeOut, this.watcher);
        if(this.acls != null) {
            for (Id id : this.ids) {
                this.zooKeeper.addAuthInfo(
                        id.getScheme(),

                        id.getId().getBytes());
            }
        }
        return this;
    }

    /**
     * 获取数据
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public byte[] getData() throws KeeperException, InterruptedException {
        return this.zooKeeper.getData(this.path, this.watcher, new Stat());
    }

    /**
     * 添加监控
     * 如果节点不存在则会激发 watcher 的 process, 且生效监听
     * state: SyncConnected
     * type: None
     * path: null
     *
     * 如果节点存在则不会激发 watcher 的 process
     */
    public ZookeeperUtils doAddListener() throws KeeperException, InterruptedException {
        this.zooKeeper.exists(this.path, true);
        return this;
    }

    /**
     * 创建临时
     * @return 创建出来的节点
     */
    public String doCreateEPHEMERAL(boolean addListener) throws KeeperException, InterruptedException, IOException {

        if(addListener)
        {
            this.doAddListener();
        }

        String path = this.zooKeeper.create(this.path, this.data,
                (this.acls == null || this.acls.size() == 0)? (List<ACL>) ZooDefs.Ids.ANYONE_ID_UNSAFE : this.acls,
                CreateMode.EPHEMERAL);
        this.zooKeeper.getData(this.path, true, new Stat());
        return path;
    }

    /**
     * 创建永久
     * @return 创建出来的节点
     */
    public String doCreatePERSISTENT(boolean addListener) throws KeeperException, InterruptedException, IOException {

        if(addListener)
        {
            this.doAddListener();
        }

        String path = this.zooKeeper.create(this.path, this.data,
                (this.acls == null || this.acls.size() == 0)? (List<ACL>) ZooDefs.Ids.ANYONE_ID_UNSAFE : this.acls,
                CreateMode.PERSISTENT);
        return path;
    }

    /**
     * 临时有序
     * @return 创建出来的节点
     */
    public String doCreateEPHEMERALSEQUENTIAL(boolean addListener) throws KeeperException, InterruptedException, IOException {

        if(addListener)
        {
            this.doAddListener();
        }

        String path = this.zooKeeper.create(this.path, this.data,
                (this.acls == null || this.acls.size() == 0)? (List<ACL>) ZooDefs.Ids.ANYONE_ID_UNSAFE : this.acls,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        return path;
    }

    /**
     * 永久有序
     * @return 创建出来的节点
     */
    public String doCreatePERSISTENTSEQUENTIAL(boolean addListener) throws KeeperException, InterruptedException, IOException {

        if(addListener)
        {
            this.doAddListener();
        }

        String path = this.zooKeeper.create(this.path, this.data,
                (this.acls == null || this.acls.size() == 0)? (List<ACL>) ZooDefs.Ids.ANYONE_ID_UNSAFE : this.acls,
                CreateMode.PERSISTENT_SEQUENTIAL);

        return path;
    }

    /**
     * 提交数据修改
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void doChangeData() throws KeeperException, InterruptedException {
        this.zooKeeper.setData(this.path, this.data, -1);
    }

    /**
     * 删除当前路径
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void doDelete() throws KeeperException, InterruptedException {
        this.zooKeeper.delete(this.path, -1);
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

}
