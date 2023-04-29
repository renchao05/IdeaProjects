package com.hspedu.Exercise;

public class OverrideExercise {
    public static void main(String[] args) {
        Person person = new Person("任潮",25);
        Student student = new Student("任超",32,"093096",99);
        System.out.println(person.say());
        System.out.println(student.say());
    }
}
