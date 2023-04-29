package com.hspedu.collection;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class HashSetExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("任超",32));
        hashSet.add(new Employee("王道月",32));
        hashSet.add(new Employee("任超",32));
        System.out.println(hashSet);
    }
}


class Employee {
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

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
//        return false;
////        Employee employee = (Employee) o;
////        return age == employee.age &&
////                Objects.equals(name, employee.name);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}