package com.hspedu.collection;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedHashMap_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        LinkedHashSet link = new LinkedHashSet();
        link.add(456);
//        link.add("任超");
//        link.add("王道月");
//        link.add("任超");
        System.out.println(link.add("任超"));
        System.out.println(link.add("王道月"));
        System.out.println(link.add("任超"));
        System.out.println(link);
    }
}
