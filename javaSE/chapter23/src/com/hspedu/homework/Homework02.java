package com.hspedu.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> fClass = Class.forName("java.io.File");
        Constructor<?>[] constructors = fClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?> constructor = fClass.getConstructor(String.class);
        Object o = constructor.newInstance("d:\\mynew.txt");
        Method createNewFile = fClass.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
