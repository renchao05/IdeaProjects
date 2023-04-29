package com.hspedu.poly_.polyarr_;

public class Person {
    private String name;
    private int age;

    public void say() {
        System.out.println(getName() + "\t我是人类。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
