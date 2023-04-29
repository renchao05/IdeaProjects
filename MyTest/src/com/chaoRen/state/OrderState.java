package com.chaoRen.state;



/**
 * 接单状态类，其需要实现LogisticsState接口
 */
public class OrderState implements LogisticsState {
    @Override
    public void doAction(JdLogistics context) {
        System.out.println("商家已经接单，正在处理中...");
    }
}

