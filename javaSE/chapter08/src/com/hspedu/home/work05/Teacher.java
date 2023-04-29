package com.hspedu.home.work05;

public class Teacher extends Employee {
    private int classDay;
    private double classSal;

    public Teacher(String name, double sal, int classDay, double classSal) {
        super(name, sal);
        this.classDay = classDay;
        this.classSal = classSal;
    }

    public void Print() {
        System.out.println(getName() + "的年工资为：" + (getSal() * 12 + classDay * classSal *12));
    }
}
