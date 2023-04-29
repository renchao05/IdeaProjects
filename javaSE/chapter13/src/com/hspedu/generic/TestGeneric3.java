package com.hspedu.generic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class TestGeneric3 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("任超", 15000, new MyDate(1993, 10, 8)));
        employees.add(new Employee("任超", 18000, new MyDate(1991, 5, 29)));
        employees.add(new Employee("任超", 18000, new MyDate(1991, 5, 27)));
        employees.add(new Employee("王道月", 5000, new MyDate(1988, 5, 25)));
        employees.add(new Employee("任子馨", 200, new MyDate(2014, 11, 22)));
        employees.add(new Employee("任传睿", 200, new MyDate(2018, 10, 24)));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i == 0)
                    return o1.getBirthday().getDate().compareTo(o2.getBirthday().getDate());
                return i;
            }
        });
        System.out.println("=============排序后=============");
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

}


class Employee {
    private String name;
    private int sal;
    private MyDate birthday;

    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

//    public LocalDate getDate() {
//        return this.birthday.getDate()
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public LocalDate getDate() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
        String d = year + "-" + month + "-" + day;
        return LocalDate.parse(d,dtf);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year +
                "年" + month +
                "月" + day + "日";
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}