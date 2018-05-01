package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeDeleted;

public class Start {

    static ZookeeperUtils zookeeperUtils;
    static ZookeeperUtils zookeeperUtils2;


    static CountDownLatch countDownLatch;
    static String basePath = "/xlj";
    static Watcher watcher =new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {

            System.out.println("state: "  + watchedEvent.getState());
            System.out.println("type: "  + watchedEvent.getType());
            System.out.println("path: "  + watchedEvent.getPath());

            Event.KeeperState state =  watchedEvent.getState();
            Event.EventType eventType = watchedEvent.getType();
            String path = watchedEvent.getPath();

            try {

                //不等于断开链接  &&  不等于超时
                if(state == Event.KeeperState.SyncConnected) {

                    //路径不为 null
                    if(path != null) {
                        //继续监听修改事件
//                      zookeeperUtils.getZooKeeper().getData("/", watcher, new Stat());

                        //读取节点数据
                        String data = "";
                        byte[] dataBytes;
                        char[] dataChars;

                        switch (eventType) {


                            case NodeCreated: //创建节点之前必须监听否则无效,如: zookeeper.exist("/test", true)
                                dataBytes = zookeeperUtils.setPath(watchedEvent.getPath()).getData();
                                dataChars = new char[dataBytes.length];
                                for (int i = 0; i < dataBytes.length; i++) {
                                    dataChars[i] = (char) dataBytes[i];
                                }
                                data = String.valueOf(dataChars);
                                System.out.println("创建节点: path=" + watchedEvent.getPath() + " data:" + data);
                                break;

                            case NodeDataChanged:
                                dataBytes = zookeeperUtils.setPath(watchedEvent.getPath()).getData();
                                dataChars = new char[dataBytes.length];
                                for (int i = 0; i < dataBytes.length; i++) {
                                    dataChars[i] = (char) dataBytes[i];
                                }
                                data = String.valueOf(dataChars);
                                System.out.println("修改节点数据: path=" + watchedEvent.getPath() + " data:" + data);
                                break;


                            case NodeChildrenChanged: //仅删除的时候父节点会收到消息
                                System.out.println("子节点修改: path=" + watchedEvent.getPath() + " data:" + data);
                                break;

                            case NodeDeleted: //删除的时候应该取消监听否则看能导致重复监听
                                System.out.println("删除节点: path=" + watchedEvent.getPath());
                                break;

                            default:
                                break;
                        }

                        if(eventType.equals(NodeDeleted))
                        {
                            zookeeperUtils.getZooKeeper().exists(path, false);
                        }
                        else {
                            zookeeperUtils.getZooKeeper().exists(path, true);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
//                countDownLatch.countDown();
            }

            System.out.println("---------------------------------------------");
            System.out.println("");
        }
    };




    public static void main(String[] args) throws KeeperException, InterruptedException, IOException, NoSuchAlgorithmException {

        //设置林权限创建节点 修改数据
        testAuthCreateSetData();

        //没有权限修改数据 会报异常
//        testNotAuthGetData();

        TimeUnit.SECONDS.sleep(120);
    }

    /**
     * 测试用权限 创建和修改数据
     * @throws KeeperException
     * @throws InterruptedException
     * @throws IOException
     */
    private static void testAuthCreateSetData() throws KeeperException, InterruptedException, IOException, NoSuchAlgorithmException {

        System.out.println("1. init");
        zookeeperUtils = initZookeeperUtils();

        //设置权限(创建的时候使用的权限)
        List<ACL> acls = new ArrayList<ACL>();
        ACL aclAll = new ACL(ZooDefs.Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest("xlj:20060619Csj")));
        acls.add(aclAll);
        zookeeperUtils.setAcls(acls);

        //初始化的时候使用的权限
        List<Id> ids = new ArrayList<Id>();
        Id idAll = new Id("digest", "xlj:20060619Csj");
        ids.add(idAll);
        zookeeperUtils.setIds(ids);

        zookeeperUtils.doInitZookeeper();
        Thread.sleep(2 * 1000);


        try {
            System.out.println("2. deleteall");
            //删除所有数据
            deleteAll(zookeeperUtils.getZooKeeper(), basePath);
            Thread.sleep(5 * 1000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }


        try{
            zookeeperUtils.setPath(basePath).setData("xlj".getBytes());

            System.out.println("3. exists: " + basePath);
            zookeeperUtils.doAddListener();
            Thread.sleep(5 * 1000);

            System.out.println("4. add persistent: " + basePath);
            zookeeperUtils.doCreatePERSISTENT(false);
            Thread.sleep(5 * 1000);

            System.out.println("4.1. change data persistent: 123 " + basePath);
            zookeeperUtils.setData("123".getBytes());
            zookeeperUtils.doChangeData();
            Thread.sleep(5 * 1000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }


        try {
            System.out.println("5. add persistent: " + basePath + "/xlj_PERSISTENT");
            zookeeperUtils.setPath(basePath + "/xlj_PERSISTENT").setData("xlj_PERSISTENT".getBytes()).doCreatePERSISTENT(true);
            Thread.sleep(5 * 1000);

            System.out.println("5.1. change data persistent: 234 " + basePath);
            zookeeperUtils.setData("234".getBytes());
            zookeeperUtils.doChangeData();
            Thread.sleep(5 * 1000);

            System.out.println("5.2. change data persistent: 345 " + basePath);
            zookeeperUtils.setData("345".getBytes());
            zookeeperUtils.doChangeData();
            Thread.sleep(5 * 1000);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }


        try {
            System.out.println("6. add persistent sequential: " + basePath+ "/xlj_PERSISTENTSEQUENTIAL");
            zookeeperUtils.setPath(basePath + "/xlj_PERSISTENTSEQUENTIAL").setData("xlj_PERSISTENTSEQUENTIAL".getBytes()).doCreatePERSISTENTSEQUENTIAL(true);
            Thread.sleep(5 * 1000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }


        try
        {
            System.out.println("7. add ephemeral: " + basePath + "/xlj_EPHEMERAL");
            zookeeperUtils.setPath(basePath + "/xlj_EPHEMERAL").setData("xlj_EPHEMERAL".getBytes()).doCreateEPHEMERAL(true);
            Thread.sleep(5 * 1000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }


        try
        {
            System.out.println("8. add ephemeral sequential: " + basePath + "/xlj_EPHEMERALSEQUENTIAL");
            zookeeperUtils.setPath(basePath + "/xlj_EPHEMERALSEQUENTIAL").setData("xlj_EPHEMERALSEQUENTIAL".getBytes()).doCreateEPHEMERALSEQUENTIAL(true);
            Thread.sleep(5 * 1000);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            initZookeeperUtils();
        }
    }

    /**
     * 测试无权限操作
     */
    private static void testNotAuthGetData() throws IOException, KeeperException, InterruptedException {

        System.out.println("1. init");
        zookeeperUtils2 = initZookeeperUtils();
        zookeeperUtils2.doInitZookeeper();
        Thread.sleep(2 * 1000);

        System.out.println("2. get data: ");
        System.out.println(zookeeperUtils2.setPath(basePath).getData().toString());

    }

    /**
     * 初始化
     * @throws IOException
     */
    public static ZookeeperUtils initZookeeperUtils() throws IOException {
         return ZookeeperUtils.getZookeeperUtils().setConnectionString("127.0.0.1:2181").setWatcher(watcher);
    }

    /**
     * 删除所有节点(递归删除)
     * @param zooKeeper
     * @param path
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void deleteAll(ZooKeeper zooKeeper, String path) throws KeeperException, InterruptedException {
        //判断节点是否存在
        Stat stat = zooKeeper.exists(path, true);

        //zookeeper 默认配置的节点不删除
        if(path == "/zookeeper" || stat == null)
        {
            return;
        }

        List<String> childrens = zooKeeper.getChildren(path, true);

        for(String child : childrens) {
            deleteAll(zooKeeper, path + "/" + child);
        }

        zooKeeper.delete(path, -1);
    }

}