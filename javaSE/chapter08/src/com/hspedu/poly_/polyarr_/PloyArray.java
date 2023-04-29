package com.hspedu.poly_.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        Person[] person = new Person[5];
        person[0] = new Person("李四",24);
        person[1] = new Teacher("马老师",42,23000);
        person[2] = new Teacher("胡老师",39,22000);
        person[3] = new Student("张强",23,88);
        person[4] = new Student("左明",22,99);
        for (int i = 0; i < person.length; i++) {
            person[i].say();
        }
        double a = 10.1;
        int b = 10;
        System.out.println(a==b);
        "hello".equals("abc");
    }
}
