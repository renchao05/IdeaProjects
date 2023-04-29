package com.chaoRen.spring5;

public class User {
    private String name;
    private Integer age;
    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void add() {
        System.out.println("add.....");
    }

    public void show() {
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + sex);
    }
}
