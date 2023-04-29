package com.renchao.pool;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newCachedThreadPool();
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
//        ExecutorService service = Executors.newWorkStealingPool();
        ExecutorService service = new ThreadPoolExecutor(3,
                3,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 30; i++) {
                int finalI = i;
                System.out.println("=============");
                service.submit(() -> {
                    try {
                        System.out.println(finalI + "   正在执行线程：" + Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            service.shutdown();
        }
    }
}
