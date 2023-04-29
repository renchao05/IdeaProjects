package com.chaoRen.chain;

import java.util.Objects;

/**
 * 小组领导类：
 */
public class GroupLeader implements BudgetHandler {
    private BudgetHandler nextHandler;

    @Override
    public void setNextHandler(BudgetHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean handle(int amount) {
        Objects.requireNonNull(nextHandler);
        if(amount<1000){
            System.out.println("小钱，批了！");
            return true;
        }
        System.out.printf("%d超出GroupLeader权限,请更高级管理层批复%n",amount);
        return nextHandler.handle(amount);
    }
}
