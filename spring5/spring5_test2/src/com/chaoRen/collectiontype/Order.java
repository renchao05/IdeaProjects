package com.chaoRen.collectiontype;

import javax.crypto.spec.PSource;

public class Order {
    private String name;
    public Order() {
        System.out.println("第一步，构造器");
    }
    public void setName(String name) {
        this.name = name;
        System.out.println("第二步，注入参数");
    }
    public void init() {
        System.out.println("第三步，初始化");
    }
    public void destroy() {
        System.out.println("第五部，销毁");
    }
}
