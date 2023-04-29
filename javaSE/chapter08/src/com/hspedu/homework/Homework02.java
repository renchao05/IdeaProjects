package com.hspedu.homework;

public class Homework02 {
    public static void main(String[] args) {
        Professor professor = new Professor("张教授", 55, "教授", 10000);
        AssociateProfessor associateProfessor = new AssociateProfessor("李副", 35, "副教授", 10000);
        Iecturer iecturer = new Iecturer("张老师", 32, "老师", 10000);
        professor.Introduce();
        associateProfessor.Introduce();
        iecturer.Introduce();
    }
}
