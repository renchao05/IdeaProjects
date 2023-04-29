package com.hspedu.home.work08;

public class Test {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(400);
//        checkingAccount.deposit(88.8);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.withdraw(100);
//        System.out.println(checkingAccount.getBalance());
        SavingsAccount savingsAccount = new SavingsAccount(500);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.deposit(88);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.withdraw(100);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.deposit(80);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.withdraw(120);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.Interest();
        System.out.println("你的钱存一个月，生了利息。。。。\n当前余额为：" + savingsAccount.getBalance() +
                "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.deposit(98);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());

        savingsAccount.withdraw(150);
        System.out.println("当前余额为：" + savingsAccount.getBalance() + "\t免手续费次数：" + savingsAccount.getFre());
    }
}
