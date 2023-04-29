package com.chaoren.interface_;

public interface MyFun {
    default String getName(){
        return "哈哈哈";
    }

    static void show(){
        System.out.println("接口中的静态方法");
    }

    default void showName(){
        String name = getName();
        System.out.println(name);
        show();
    }
}
