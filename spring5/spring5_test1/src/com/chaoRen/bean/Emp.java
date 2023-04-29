package com.chaoRen.bean;

public class Emp {
    private String name;
    private Character sex;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add() {
        System.out.println(name);
        System.out.println(sex);
        System.out.println(dept);
    }
}
