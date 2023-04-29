package com.renchao.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}


class Task implements Runnable{

    public static Map<String, Object> data = new Hashtable<>();
    public static ThreadLocal<Object> tl = new ThreadLocal<>();
    @Override
    public void run() {
        int i = new Random().nextInt(1000);
        String name = Thread.currentThread().getName();
        System.out.println("当前线程【" + name + "】的i值是：" + i);
        data.put(name, i);
        tl.set(i);

        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程【" + name + "】快结束时data的i值是：" + data.get(name));
        System.out.println("当前线程【" + name + "】快结束时tl的i值是：" + tl.get());
        new A().test(data,tl);
    }
}

class A {
    public void test(Map<String, Object> data,ThreadLocal<Object> tl) {
        String name = Thread.currentThread().getName();
        System.out.println("线程【" + name + "】A的data的i值是：" + data.get(name));
        System.out.println("线程【" + name + "】A的tl的i值是：" + tl.get());
    }
}