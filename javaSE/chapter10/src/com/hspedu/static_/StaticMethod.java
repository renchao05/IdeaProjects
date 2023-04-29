package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        Stu p1 = new Stu("小明 ");
        Stu p2 = new Stu("小王");
        p1.payFee(200);
        p2.payFee(300);
        Stu.payFee(300);
        System.out.println(Stu.fee);
        System.out.println(p1.fee);
        System.out.println(p2.fee);
    }
}

class Stu {
    private String name;
    public static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }

    public static void payFee(double fee) {
        Stu.fee += fee;
    }
}