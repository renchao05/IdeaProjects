package com.hspedu.poly_polyparameter_;

public class Manage extends Employee{
    private double bonus;

    public Manage(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }

    public void employee(){
        System.out.println(getName() + "正在进行管理工作。。。。");
    }
}
