package com.renchao.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1,true);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
//                    System.out.println(Thread.currentThread().getName() + "在找车位！！");
                    try {
                        semaphore.acquire();    // 占车位
                        System.out.println(Thread.currentThread().getName() + "找到位！！===========");
//                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
//                        System.out.println(Thread.currentThread().getName() + "开走了。。。。。。。。。。。。。。。。。。。");
                        semaphore.release();    // 释放车位
                    }
                }
            }, "车主" + i).start();
        }
    }
}
