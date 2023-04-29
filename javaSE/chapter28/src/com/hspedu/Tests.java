package com.hspedu;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Tests {
    public static void main(String[] args) {
//        Tests2 tests2 = new Tests2();
//        System.out.println(tests2.getName());
        TreeSet<Integer> set = new TreeSet<Integer>();
        TreeSet<Integer> set2 = new TreeSet<Integer>();
        set.add(166);
        set.add(77);
        set.add(55);
        set.add(66);
        set.add(88);
        set.add(90);
        set.add(100);
        set2 =(TreeSet)set.subSet(77, 101);
        System.out.println(set);
        System.out.println(set2);
    }
}
