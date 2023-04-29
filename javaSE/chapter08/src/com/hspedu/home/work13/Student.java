package com.hspedu.home.work13;

public class Student extends Person{
    private String stu_id;

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public Student(String name, int age, char sex, String hobby, String stu_id) {
        super(name, age, sex, hobby);
        this.stu_id = stu_id;
    }

    public void Study() {
        System.out.println("我承诺，我会好好学习。");
    }
}
