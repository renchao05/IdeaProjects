package com.hspedu.poly_.polyarr_;

public class Student extends Person {
    private double res;

    public void say() {
        System.out.println(getName() + "\t我是学生，正在上课。。。。");
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public Student(String name, int age, double res) {
        super(name, age);
        this.res = res;
    }
}
