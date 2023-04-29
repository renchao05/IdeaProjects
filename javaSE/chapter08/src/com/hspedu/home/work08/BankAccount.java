package com.hspedu.home.work08;

public class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    //存款
    public void deposit(double amount) {
        balance += amount;
    }
    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }
}
