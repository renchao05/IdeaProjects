package com.hspedu.home.work04;

public class Homework04 {
    public static void main(String[] args) {
        Manager ms = new Manager("张三", 200, 25,1000);
        Worker li = new Worker("李清", 150, 28);
        ms.Print();
        li.Print();
    }
}
