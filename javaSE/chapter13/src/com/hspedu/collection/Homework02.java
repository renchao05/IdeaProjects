package com.hspedu.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car2 bm = new Car2("宝马", 400000);
        arrayList.add(bm);
        arrayList.add(new Car2("宾利",5000000));
        arrayList.add("任超");
        arrayList.add("王道月");
        System.out.println(arrayList);
//        arrayList.remove(bm);
        System.out.println(arrayList.contains(bm));
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
//        arrayList.clear();
        ArrayList li = new ArrayList();
        li.add("任超");
        li.add("王道月");
        li.add(bm);
        System.out.println("多个查找 = " + arrayList.containsAll(li));
//        System.out.println("多个删除 = " + arrayList.removeAll(li));
        System.out.println(arrayList);
        Iterator iterator = arrayList.iterator();
        System.out.println("=====================================");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof Car2) {
                Car2 car = (Car2) next;
                System.out.println(car);
            } else System.out.println(next);
        }
        System.out.println("=====================================");
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("=====================================");
        for (Object o : arrayList) {
            System.out.println(o);
        }

    }
}

class Car2 {
    private String name;
    private int price;

    public Car2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}