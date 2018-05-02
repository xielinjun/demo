package com.xlj.zookeeper.jdk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public interface DistributeLockWatcher extends Watcher {

    public DistributeLock getDistributeLock();

    public void setDistributeLock(DistributeLock distributeLock);
}
