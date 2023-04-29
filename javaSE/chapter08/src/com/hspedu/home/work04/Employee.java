package com.hspedu.home.work04;

public class Employee {
    private String name;
    private double per;
    private int days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Employee(String name, double per, int days) {
        this.name = name;
        this.per = per;
        this.days = days;
    }

    public void Print() {
        System.out.println(name + "的工资为：" + per * days);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", per=" + per +
                ", days=" + days +
                '}';
    }
}
