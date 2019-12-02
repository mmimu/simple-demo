package com.mimu.simple.comn.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 author: mimu
 date: 2019/12/2
 */
public class CuratorDLOperator {
    private InterProcessMutex lock;

    public CuratorDLOperator(CuratorFramework client, String path) {
        this.lock = new InterProcessMutex(client, path);
    }

    public boolean getLock(int time, TimeUnit timeUnit) throws Exception {
        return lock.acquire(time, timeUnit);
    }

    public boolean releaseLock() throws Exception {
        lock.release();
        return true;
    }
}
