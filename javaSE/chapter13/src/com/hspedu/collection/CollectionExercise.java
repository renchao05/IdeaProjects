package com.hspedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List col = new ArrayList();
        col.add(new Dog("小白",3));
        col.add("超超");
        col.add(new Dog("花花",1));
        col.add(new Dog("大熊",4));
        col.add(new Dog("泰迪",7));
        col.add("大大");
        col.add("王帮贡");
        col.add("东嗯好");
        col.add("董恩浩");
        col.add("王钢镚");
        col.add("王拨号");
        col.add("王拨");
        System.out.println(col.get(1));
        System.out.println(col);
        System.out.println("================================");
        col.add(2,"韩顺平教育");
        System.out.println(col.get(4));
        System.out.println(col);
        System.out.println("================================");
        col.remove(5);
        System.out.println(col);
        System.out.println("================================");
        col.set(6,"玉皇大帝");
        System.out.println(col);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}

class Dog {
    private String name;
    private int age;

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

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}