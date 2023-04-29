package com.renchao.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    private static Integer num = 10;
    /**
     * 对一个数加 10,
     */
    public static void main(String[] args) throws Exception{
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            int i= 1/0;
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return -1;
        });
        System.out.println(future.get());
    }
}
