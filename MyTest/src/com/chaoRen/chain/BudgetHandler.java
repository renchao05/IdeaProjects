package com.chaoRen.chain;

public interface BudgetHandler {
    void setNextHandler(BudgetHandler nextHandler);

    boolean handle(int amount);
}
