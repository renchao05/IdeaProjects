package com.hspedu.homework;

public class AssociateProfessor extends Studenter {
    public AssociateProfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public void Introduce() {
        System.out.println("姓名：" + getName() + "\t年龄：" + super.getAge() +
                "\t职称：" + super.getPost() + "\t薪水：" + super.getSalary() * 1.2);
    }
}
