package com.hspedu.home.work13;

public class Teacher extends Person{
    private int work_age;

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public Teacher(String name, int age, char sex, String hobby, int work_age) {
        super(name, age, sex, hobby);
        this.work_age = work_age;
    }
    public void Teach() {
        System.out.println("我承诺，我会认真教课。");
    }
}
