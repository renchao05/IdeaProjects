package com.hspedu.poly_.polyarrs2;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("任超", 32, '男');
        Person p2 = new Person("任超", 31, '男');
        Person p3 = p1;
        System.out.println(p1.equals(p2));
        System.out.println("==================");
        System.out.println("p1的hashcode:" + p1.hashCode());
        System.out.println("p2的hashcode:" + p2.hashCode());
        System.out.println("p3的hashcode:" + p3.hashCode());
        System.out.println(p3.toString());


    }
}
