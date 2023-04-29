package com.hspedu.home.work08;

public class SavingsAccount extends EarnMonthlylnterest{
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    //存款
    public void deposit(double amount) {
        if (getFre() > 0) {
            setBalance(getBalance() + amount);
            setFre(getFre() - 1);
        } else {
            super.deposit(amount);
        }

    }

    //取款
    public void withdraw(double amount) {
        if (getFre() > 0) {
            setBalance(getBalance() - amount);
            setFre(getFre() - 1);
        } else {
            super.withdraw(amount);
        }

    }
}
