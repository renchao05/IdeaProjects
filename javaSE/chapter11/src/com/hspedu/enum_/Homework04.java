package com.hspedu.enum_;

public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        },4,5);
    }
}

interface Calculator {
    public double work(double n1, double n2);
}

class Cellphone {
    public void testWork(Calculator calculator, double n1, double n2) {
        System.out.println(calculator.work(n1,n2));
    }
}