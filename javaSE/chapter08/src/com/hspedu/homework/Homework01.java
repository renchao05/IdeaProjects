package com.hspedu.homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Person("小明",34,"工程师");
        person[1] = new Person("李四", 22,"大学生");
        person[2] = new Person("大大",44,"老板");
        person[3] = new Person("大可爱",45,"老板");
        Person temp = null;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i -1; j++) {
                if (person[j].getAge() < person[j + 1].getAge()) {
                    temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].getName());
        }
    }
}
