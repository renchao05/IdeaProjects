package com.renchao;


import com.renchao.test.VolatileTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 具有指定等待时间的等待线程的线程状态。 由于以指定的正等待时间调用以下方法之一，线程处于定时等待状态：
 * Thread.sleep
 * Object.wait 超时
 * Thread.join 超时
 * LockSupport.parkNanos
 * LockSupport.parkUntil
 */

public class TestMain {
    public static void main(String[] args) throws InterruptedException {

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        lock.writeLock().unlock();

    }
}
