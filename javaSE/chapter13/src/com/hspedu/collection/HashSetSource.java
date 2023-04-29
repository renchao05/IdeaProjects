package com.hspedu.collection;

import java.util.HashSet;

public class HashSetSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("任超");
        hashSet.add("王道月");
        hashSet.add("任超");
        System.out.println(hashSet);
    }
}
