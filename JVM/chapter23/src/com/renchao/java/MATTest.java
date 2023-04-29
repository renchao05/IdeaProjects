package com.renchao.java;

import java.util.Scanner;

public class MATTest {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}

class AAA {
    public Integer id;
    public String name;
    public BBB bbb = new BBB();

}

class BBB {
    public Integer BId;
    public String BName;
}