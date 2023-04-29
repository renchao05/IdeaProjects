package com.hspedu.poly_polyparameter_;

public class WorkEmployee extends Employee {
    public WorkEmployee(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println(getName() + "正在工作。。。。");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
