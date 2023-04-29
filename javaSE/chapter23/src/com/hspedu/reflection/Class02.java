package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();

        Method method = cls.getDeclaredMethod("eat", String.class);
        method.setAccessible(true);
        method.invoke(o,"老狗");
    }
}
