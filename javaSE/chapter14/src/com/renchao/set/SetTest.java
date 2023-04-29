package com.renchao.set;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "cc");
        }
        ArrayList<String> dest = new ArrayList<>(list.size());
        dest.add("s");
        Collections.copy(dest, list);
    }
}
