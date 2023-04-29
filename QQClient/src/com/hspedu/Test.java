package com.hspedu;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class Test {
    public static void main(String[] args) {
        HashMap<String, LinkedHashSet<String>> hm = new HashMap<>();
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("任超");
        hm.put("任超",strings);
        hm.get("任超").add("王道月");
        hm.get("任超").add("任子馨");
        hm.get("任超").add("任传睿");
        System.out.println(hm.get("任超"));
    }
}