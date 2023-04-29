package com.chaoRen.Iterator;

import java.util.Iterator;

public class IteratorClient {
    public static void main(String[] args) {
        Class cls= new Class();
        System.out.println("--------------开始点名--------------");
        Iterator<Student> iterator= cls.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
