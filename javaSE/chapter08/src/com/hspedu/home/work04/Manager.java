package com.hspedu.home.work04;

public class Manager extends  Employee{
    private int bonus;

    public Manager(String name, double per, int days, int bonus) {
        super(name, per, days);
        this.bonus = bonus;
    }

    public void Print() {
        System.out.println(super.getName() + "的工资为：" +
                (bonus + super.getPer() * super.getDays() * 1.2));
    }
}
