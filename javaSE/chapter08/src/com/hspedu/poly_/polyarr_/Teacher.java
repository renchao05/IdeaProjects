package com.hspedu.poly_.polyarr_;

public class Teacher extends Person {
    private double salary;

    public void say() {
        System.out.println(getName() + "\t我是老师，我正在授课。。。。");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
}
