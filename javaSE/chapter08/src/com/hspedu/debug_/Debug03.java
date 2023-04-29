package com.hspedu.debug_;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Debug03 {
    public static void main(String[] args) {
        int[] arr = {1,-2,5,9,4};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
