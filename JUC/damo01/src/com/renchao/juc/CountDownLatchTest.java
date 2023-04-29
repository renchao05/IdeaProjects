package com.renchao.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch count = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " 离开了。。。");
                count.countDown();
            },"同学 " + i).start();
        }

        count.await();
        System.out.println("同学都走了，值日同学关门了======");
    }
}
