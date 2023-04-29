package com.hspedu.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        CommonEmployee e1 = new CommonEmployee("张三", 1005, 5000);
        Manager e2 = new Manager("李时", 1005, 6000, 10000);
        e1.work();
        e2.work();
    }
}

abstract class Employee {
    private String name;
    private int id;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    abstract public void work();
}

class Manager extends Employee {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + getName() + "正在工作。。。。");
    }
}

class CommonEmployee extends Employee {

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("员工" + getName() + "正在工作。。。。");
    }
}