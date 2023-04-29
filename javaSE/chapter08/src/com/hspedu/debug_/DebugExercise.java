package com.hspedu.debug_;

public class DebugExercise {
    public static void main(String[] args) {
        Person person = new Person("任超",31);
        System.out.println(person);
    }
}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}