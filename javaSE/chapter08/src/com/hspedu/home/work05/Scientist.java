package com.hspedu.home.work05;

public class Scientist extends Employee{
    private double bonus;

    public Scientist(String name, double sal, double bonus) {
        super(name, sal);
        this.bonus = bonus;
    }

    public void Print() {
        System.out.println(getName() + "的年工资为：" + (getSal() * 12 + bonus));
    }
}
