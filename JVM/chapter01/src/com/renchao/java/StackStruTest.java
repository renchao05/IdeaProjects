package com.renchao.java;

import java.util.ArrayList;
import java.util.Scanner;

public class StackStruTest {
    public static void main(String[] args) {
        ArrayList<Object> students = new ArrayList<>();
        while (true) {
//            students.add(new Student());
            AA aa = new AA() {
            };
            students.add(aa);
        }
//        Scanner scanner = new Scanner(System.in);
//        scanner.next();
    }
}

class Student {
    private Integer id;
    private String name;
    private Integer age;
    private byte[] message = new byte[1024 * 1024];
}

interface AA {
//    public static byte[] message = new byte[1024 * 1024];
}