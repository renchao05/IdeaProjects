package com.hspedu.home.work04;

public class Worker extends Employee {
    public Worker(String name, double per, int days) {
        super(name, per, days);
    }

    public void Print() {
        System.out.println(super.getName() + "的工资为：" +
                super.getPer() * super.getDays());
    }
}
