package com.chaoRen.collectiontype;

import java.util.List;

public class Book {
    private List<String> list;
    public Book() {
        System.out.println("第一步，构造器");
    }
    public void setList(List<String> list) {
        this.list = list;
        System.out.println("第二步，注入参数");
    }
    public void show() {
        System.out.println(list);
    }
    public void init() {
        System.out.println("第三步，初始化");
    }
    public void destroy() {
        System.out.println("第五步，销毁");
    }
}
