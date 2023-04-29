package com.renchao.java;

public class Test01 {
    public static void main(String[] args) {
        System.out.println(A.str1);
//        System.out.println(A.str2);
        System.out.println(A.str3);
    }
}


class A {
    public static final String str1 = "RENCHAO";
//    public static final String str2 = new String("王道月");
    public static final Integer str3 = Integer.valueOf(100);

    static {
        System.out.println("类初始化了！！！");
    }
}