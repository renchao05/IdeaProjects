package com.hspedu.home.work10;

public class Test {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("小明", 32, "工程师", '男', 20000);
        Doctor doctor2 = new Doctor("小明", 32, "工程师", '男', 20000);
        System.out.println(doctor1.equals(doctor2));
    }
}
