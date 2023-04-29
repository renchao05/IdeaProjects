package com.hsbedu.encap;

/* 创建程序,在其中定义两个类：Account 和 AccountTest 类体会 Java 的封装性。
* Account 类要求具有属性：姓名（长度为 2 位 3 位或 4 位）、余额(必须>20)、
* 密码（必须是六位）, 如果不满足，则给出提示信息，并给默认值(程序员自己定)
* 通过 setXxx 的方法给 Account 的属性赋值。
* 在 AccountTest中测试
*/

public class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            this.name = "小明";
            System.out.println("名字长度不对，请输入2-3个字符。默认：小明");
        }
    }

    public double getBalance() {
        return balance;
    }
//1 related problem
    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            this.balance = 20;
            System.out.println("余额必须大于20，置为默认值20.");
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            this.password = "111111";
            System.out.println("密码必须为6为字符，置为默认111111.");
        }
    }

    public String info(){
        return "姓名：" + name + "\t余额：" + balance + "\t密码：" + password;
    }
}
