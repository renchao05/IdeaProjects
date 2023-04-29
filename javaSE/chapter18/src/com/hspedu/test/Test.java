package com.hspedu.test;

import java.awt.*;
import java.util.Vector;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        Vector<A> vector = new Vector<>();
        vector.add(new A(1));
        vector.add(new A(2));
        vector.add(new A(3));
        vector.add(new A(4));
        vector.add(new A(5));

        System.out.println(vector);
        vector.removeIf(new Predicate<A>() {
            @Override
            public boolean test(A a) {
                return a.i == 3 || a.i == 4;
            }
        });
        System.out.println(vector);

        System.out.println(Panel.class.getResource("/bomb_1.gif"));

    }
}

class A {
    public int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "" + i;
    }
}