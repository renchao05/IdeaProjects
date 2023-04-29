package com.hspedu.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle3 circle3 = new Circle3();
        Circle4 circle4 = new Circle4();
        System.out.println("circle的计算结果：" + circle.area(3));
        System.out.println("circle2的计算结果：" + Circle2.area(3));
        System.out.println("circle3的计算结果：" + circle3.area(3));
        System.out.println("circle4的计算结果：" + circle4.area(3));
        System.out.println("circle5的计算结果：" + Circle5.area(3));
        System.out.println("CC的计算结果：" + CC.area(3));
    }
}

abstract class Circle5 {
    private static double radius;
    private static final double PI;

    static {
        PI = 3.14;
    }

    public static double area(double radius) {
        return PI * radius * radius;
    }
}

class Circle4 {
    private double radius;
    private final double PI;
    {
        PI = 3.14;
    }
    public double area(double radius) {
        return PI * radius * radius;
    }
}

class Circle3 {
    private double radius;
    private final double PI;

    public Circle3() {
        PI = 3.14;
    }
    public double area(double radius) {
        return PI * radius * radius;
    }
}

class Circle {
    private double radius;
    private final double PI = 3.14;

    public double area(double radius) {
        return PI * radius * radius;
    }
}

class Circle2 {
    private static double radius;
    private static final double PI =3.14;

    public static double area(double radius) {
        return PI * radius * radius;
    }
}

abstract class CC extends Circle2 {

    public static double area(double radius) {
        return radius * radius;
    }
}