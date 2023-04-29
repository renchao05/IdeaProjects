package com.renchao.lock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockTest02 {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //十个写线程
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(() -> myCache.put(temp + "", temp + ""), String.valueOf(i)).start();
        }
        //十个读线程
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(() -> myCache.get(temp + ""), String.valueOf(i)).start();
        }
    }
}

/**
 * 自定义缓存
 */
class MyCache {
    private volatile  Map<String, Object> map = new HashMap<>();

    //存入值
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "写入" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完成");
    }

    //取值
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "读取" + key);
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成");
    }

}
