package com.hspedu.home.work08;

public class CheckingAccount extends BankAccount {
    private double commission = 1;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    //存款
    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    //取款
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
