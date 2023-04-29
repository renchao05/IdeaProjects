package com.hspedu;

public class Cat extends Animal implements Head {
    private String name = "小黄猫";
    private static int age = 100;

    public Cat() {}

    private Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        Cat.age = age;
    }

    public Long hi(Long n1, Long n2) {
//        System.out.println("我是：" + name);
        return n1 + n2;
    }

    public void cry() {
        System.out.println("我是小小猫，哈哈哈哈。。。。。");
    }

    private void eat(String name) {
        System.out.println("小狗吃东西。。。。。。。。");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
