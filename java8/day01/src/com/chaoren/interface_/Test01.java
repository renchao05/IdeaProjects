package com.chaoren.interface_;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test01 {
    public static void main(String[] args) {
        MyFun myFun = new TestMyFun();
        String name = myFun.getName();
        System.out.println(name);
        MyFun.show();
    }
}
