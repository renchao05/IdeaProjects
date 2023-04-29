package com.hspedu.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        A a = new A(44.5);
        System.out.println(a.TAX_RATE);
    }
}

class A{
    public final double TAX_RATE;

    public A(double TAX_RATE) {
        this.TAX_RATE = TAX_RATE;
    }
}