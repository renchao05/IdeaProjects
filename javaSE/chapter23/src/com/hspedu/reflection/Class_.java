package com.hspedu.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class_ {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Class.forName();动态加载类。
        Class<?> catClass = Class.forName("com.hspedu.Cat");

        //getName()：返回此Class对象所表示的实体(类、接口、数组类、基本类型等)名称
        String name = catClass.getName();
        String simpleName = catClass.getSimpleName();
        System.out.println(simpleName);

        //newInstance() ：根据对象的class新建一个对象
        Object o = catClass.newInstance();

        //getSuperclass() 获取继承的父类
        Class<?> superclass = catClass.getSuperclass();

        //getInterfaces() 获取实现的所有接口
        Class<?>[] interfaces = catClass.getInterfaces();

        //getDeclaredFields() 获取所有Field对象
        Field[] fields = catClass.getDeclaredFields();

        //getDeclaredMethods();获取当前类的所有方法
        Method[] methods = catClass.getDeclaredMethods();

        //getDeclaredConstructors() ：获得所有的构造函数。
        Constructor<?>[] constructors = catClass.getDeclaredConstructors();

        //getModifiers() ： 获得类修饰符
        int modifiers = catClass.getModifiers();
        System.out.println(modifiers);

        //getPackage() ：反射中获得package
        Package aPackage = catClass.getPackage();
        System.out.println(aPackage);

        //getField(String name)：反射中获得域成员。
        //getFields() :获得域数组成员。
        //isAnnotation() ：判断是否为注解类型。
        boolean annotation = catClass.isAnnotation();
        System.out.println(annotation);
        //isPrimitive() ：判断是否为基本类型。
        //isArray() ：判断是否为数组类型。
        //isEnum() ：判断是否为枚举类型。
        //getClassLoader() ：获得类的类加载器
        ClassLoader classLoader = catClass.getClassLoader();
        //getMethods() 获得公共的方法。
    }

    @Test
    public void test01() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Method hi = catClass.getMethod("hi",String.class,int.class);
        Constructor<?> constructor = catClass.getConstructor();
        Class<?>[] types = hi.getParameterTypes();
        for (Class<?> type : types) {
            System.out.println(type);
        }
    }

    @Test
    public void test02() throws Exception {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Object o = catClass.newInstance();
    }

    @Test
    public void test03()  throws Exception {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Constructor<?> constructor = catClass.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("大猫", 3);
        System.out.println(o);
    }

    @Test
    public void test04() throws Exception {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Constructor<?> constructor = catClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);    //对私有权限进行爆破
        Object o = constructor.newInstance("大猫");
        System.out.println(o);
    }

    @Test
    public void test05() throws Exception  {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Object o = catClass.newInstance();
        Field nameField = catClass.getDeclaredField("name");//获取名称为name的属性
        nameField.setAccessible(true);  //对私有属性进行爆破

        System.out.println(nameField.get(o));   //读取对象o的属性值。

        nameField.set(o,"大白猫");
        System.out.println(nameField.get(o));   //设置对象o的属性值。

        Field ageField = catClass.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println(ageField.get(null));//age为静态属性，参数可以填null
        ageField.set(null, 88);//age为静态属性，参数可以填null
        System.out.println(ageField.get(null));
    }

    @Test
    public void test06() throws Exception {
        Class<?> catClass = Class.forName("com.hspedu.Cat");
        Object o = catClass.newInstance();
        Method eatMethod = catClass.getDeclaredMethod("eat", String.class);
        eatMethod.setAccessible(true);//爆破
        Object catEat = eatMethod.invoke(o, "大猫猫");//
        System.out.println(catEat);
    }
}
