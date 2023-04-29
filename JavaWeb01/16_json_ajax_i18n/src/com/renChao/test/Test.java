package com.renChao.test;

import java.lang.reflect.ParameterizedType;
import java.util.Locale;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {

    }

    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了。。。");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了。。。");
            }
        });
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}

class A<T> {
    public String getType() {
        return null;
    }
}