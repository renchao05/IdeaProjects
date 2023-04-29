package com.hspedu.collection;

import java.util.*;

public class MapSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","任超");
        map.put("任超","王道月");
        map.put("任超","王道月");
        System.out.println("============entrySet的for=============");
        for (Object o : map.entrySet()) {
//            System.out.println(o.getClass());
            Map.Entry node = (Map.Entry) o;
            System.out.println(node.getKey() + "==" + node.getValue());
        }

        System.out.println("============entrySet的迭代器=============");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println(next.getKey() + "==" + next.getValue());
        }

        System.out.println("============keySet的for=============");
        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }

        System.out.println("============keySet的迭代器=============");
        iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("============values的for=============");
        Collection values = map.values();
        for (Object o : values) {
            System.out.println(o);
        }

        System.out.println("============values的迭代器=============");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
            System.out.println(next.getClass());
        }


//        System.out.println(map);
//        System.out.println(map.get("任超"));
//        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        System.out.println(map.containsKey("任超2"));
//        System.out.println("===========================");
//        System.out.println(map);
//        map.clear();
//        System.out.println(map.isEmpty());

    }
}

class AAA {
    private String name;

    public AAA(String name) {
        this.name = name;
    }
}