package com.hkl;

import java.lang.reflect.Method;

/**
 * Hello world!
 */
@Info(info = "hkl", birthday = "2019/7/20")
@Desc("这是一个类")
public class App {
    @Info(info = "hkl", birthday = "2019/7/20", age = 22)
    @Desc("这是一个方法")
    public static void main(String[] args) {
        // 解析注解
        try {
            Class clazz = Class.forName("com.hkl.App");
            // 获取类修饰的注解
            System.out.println("---------类中的注解---------");
            if (clazz.isAnnotationPresent(Info.class)) {
                Info classInfo = (Info) clazz.getAnnotation(Info.class);
                System.out.println(classInfo.info());
                System.out.println(classInfo.birthday());
                System.out.println(classInfo.age());
            }


            if (clazz.isAnnotationPresent(Desc.class)) {
                Desc classDesc = (Desc) clazz.getAnnotation(Desc.class);
                System.out.println(classDesc.value());
            }

            // 获取方法修饰的注解
            Method[] methods = clazz.getMethods();

            System.out.println("---------方法中的注解解析---------");
            for (Method method : methods) {
                if (method.isAnnotationPresent(Desc.class)) {
                    Desc methodDesc = (Desc) method.getAnnotation(Desc.class);
                    System.out.println(methodDesc.value());
                }

                if (method.isAnnotationPresent(Info.class)) {
                    Info methodInfo = (Info) method.getAnnotation(Info.class);
                    System.out.println(methodInfo.info());
                    System.out.println(methodInfo.birthday());
                    System.out.println(methodInfo.age());
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}