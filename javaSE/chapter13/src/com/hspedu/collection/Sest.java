package com.hspedu.collection;

public class Sest {
    public static void main(String[] args) {
        String s = "任超";
        int h = s.hashCode();
        int n1 = 0;
        System.out.println("(n1=33)*3的结果：" + (n1 = 3) * 3);
        System.out.println("s的Hash:" + h);
        System.out.println("最终值：" + (h ^ (h >>> 16)));

    }
}
