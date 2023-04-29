package com.hspedu.collection;

import java.util.ArrayList;

public class ArrayListSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList iist = new ArrayList(8);
        for (int i = 1; i <= 10; i++) {
            iist.add("我是" + i + "号。");
        }
        iist.add(3,"大壮");
        for (int i = 11; i <= 15; i++) {
            iist.add("我是" + i + "号。");
        }
        iist.add(10000);
        iist.add(88800);
        iist.add(null);
        for (Object o : iist) {
            System.out.println(o);
        }

    }
}
