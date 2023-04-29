package com.chaoRen.chain;

import java.util.Objects;

/**
 * 经理类:
 */
public class Manager implements BudgetHandler {
    private BudgetHandler nextHandler;

    @Override
    public void setNextHandler(BudgetHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(int amount) {
        Objects.requireNonNull(nextHandler);
        if(amount<5000){
            System.out.println("小于2000块，我这个经理可以决定：同意！");
            return true;
        }
        System.out.printf("%d超出Manager权限,请更高级管理层批复%n",amount);
        return nextHandler.handle(amount);
    }
}
