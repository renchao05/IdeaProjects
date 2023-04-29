package com.hsbedu.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("王道余");
        account.setBalance(10000.5);
        account.setPassword("w12345");
        System.out.println(account.info());

    }
}
