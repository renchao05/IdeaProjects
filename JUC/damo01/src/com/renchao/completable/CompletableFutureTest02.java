package com.renchao.completable;

import java.util.concurrent.CompletableFuture;

/**
 * 有返回值的异步任务
 */
public class CompletableFutureTest02 {
    public static void main(String[] args) throws Exception{
        System.out.println("主线程开始");
        //运行一个有返回值的异步任务
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("子线程开始任务");
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "子线程完成了!";
                });
        //主线程阻塞
        String s = future.get();
        System.out.println("主线程结束, 子线程的结果为:" + s);
    }
}
