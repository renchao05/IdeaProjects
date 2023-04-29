package com.renchao.callable;

import java.util.concurrent.*;

/**
 * FutureTask 使用的适配器模式
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("进程正常执行中。。。。");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("进程执行结束。。。");
            return "test";
        });

        new Thread(task,"线程Callable01").start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("是否取消成功：" + task.cancel(false));

        System.out.println("任务是否被取消：" + task.isCancelled());

        System.out.println("任务是否完成：" + task.isDone());

        TimeUnit.SECONDS.sleep(5);
        System.out.println(task.get());
    }
}
