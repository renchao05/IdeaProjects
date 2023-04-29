package com.atguigu.servlets;


public class MyTest {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        String e = "ssss";
        new A().test();
    }
}


class A {
    public void test() {
        System.out.println(this);


    }


}
