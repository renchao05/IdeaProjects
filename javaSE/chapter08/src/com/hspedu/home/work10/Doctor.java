package com.hspedu.home.work10;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor(String name, int age, String job, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return ((Doctor) obj).getName().equals(this.name)
                && ((Doctor) obj).getAge() == this.age
                && ((Doctor) obj).getJob().equals(this.job)
                && ((Doctor) obj).getGender() == this.gender
                && ((Doctor) obj).getSalary() == this.salary;
    }
}
