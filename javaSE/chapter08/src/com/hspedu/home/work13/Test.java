package com.hspedu.home.work13;

public class Test {
    public static void main(String[] args) {
        Person[] person = new Person[4];

        person[0] = new Student("小明", 18, '男', "足球", "093096");
        person[1] = new Student("大明", 23, '男', "足球", "093088");

        person[2] = new Teacher("马老师", 45, '男', "象棋", 21);
        person[3] = new Teacher("王老师", 32, '女', "跳舞", 9);

        Person temp;
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[j].getAge() < person[j+1].getAge()) {
                    temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].getName());
        }

    }
}
