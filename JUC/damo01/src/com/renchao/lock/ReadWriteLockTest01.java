package com.renchao.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest01 {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest01 test = new ReadWriteLockTest01();

        // 写线程
        new Thread(() -> test.get("r"), "BB").start();

        // 读线程
        new Thread(() -> test.get("w"), "AA").start();

    }

    public void get(String rw) {
        try {
            if (!rw.equals("r") && !rw.equals("w")) {
                return;
            }


            if (rw.equals("r")) {
                lock.readLock().lock();
            } else {
                lock.writeLock().lock();
            }
            for (int i = 0; rw.equals("r") && i < 10; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "正在进行读操作");
            }

            for (int i = 0; rw.equals("w") && i < 10; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + "正在进行写操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rw.equals("r")) {
                lock.readLock().unlock();
            } else {
                lock.writeLock().unlock();
            }
        }
    }
}
