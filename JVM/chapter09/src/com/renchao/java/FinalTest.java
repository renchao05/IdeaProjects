package com.renchao.java;

public class FinalTest {
    public static void main(String[] args) {
        AAA aaa = null;

        System.out.println(aaa.str);
    }
}

class AAA {
    public static String str = "测试final..";
    static {
        System.out.println("AAA类被加载了。。。");
        String intern = str.intern();
        System.out.println(intern);
    }
}