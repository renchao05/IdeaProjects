package com.hspedu.try_;

import java.util.Arrays;
import java.util.Comparator;

public class TryCatchDetail {
    public static void main(String[] args) {
        Integer[] i = {3,9,6,10,18,8,4};
        System.out.println(Arrays.toString(i));
        Arrays.sort(i, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(i));
    }
}
