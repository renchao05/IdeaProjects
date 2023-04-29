package com.renchao.muster;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
        Map<String, Object> map = new ConcurrentHashMap<>();
        Map<String, Object> map2 = new Hashtable<>();
//        List<String> list = new ArrayList<>();    //线程不安全，会报并发修改异常ConcurrentModificationException
//        List<String> list = new Vector<>();   // 安全
//        List<String> list = Collections.synchronizedList(new ArrayList<>());  // 安全
        List<String> list = new CopyOnWriteArrayList<>();   // 安全
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> list.add(finalI + "1")).start();
            new Thread(() -> list.add(finalI + "2")).start();
            new Thread(() -> list.add(finalI + "3")).start();
            new Thread(() -> list.add(finalI + "4")).start();
            System.out.println(list);
        }
    }
}
