package com.hspedu.home.work08;

public class EarnMonthlylnterest extends CheckingAccount {
    private double interest = 0.0075;
    private int fre = 3;

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }

    public EarnMonthlylnterest(double initialBalance) {
        super(initialBalance);
    }
    public void Interest() {
        setBalance(getBalance() * interest);
        fre = 3;
    }
}
