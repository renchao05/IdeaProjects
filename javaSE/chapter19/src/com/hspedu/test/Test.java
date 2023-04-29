package com.hspedu.test;

public class Test {
    public static void main(String[] args) {
        BufferedReader_ buffered1 = new BufferedReader_(new FileReader_());
        BufferedReader_ buffered2 = new BufferedReader_(new StringReader_());
        buffered1.read();
        buffered2.read();
        System.out.println("=============================");
        buffered1.read(5);
        System.out.println("=============================");
        buffered2.read(5);
    }
}
