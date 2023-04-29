package com.hspedu.collection;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        LinkedHashSet link = new LinkedHashSet();
        link.add(new Car("宝马",30));
        link.add(new Car("奥迪",53));
        link.add(new Car("宝马",30));
        link.add(new Car("五菱",6));
        System.out.println(link);
    }
}


class Car {
    private String name;
    private int price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return price == car.price &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }
}