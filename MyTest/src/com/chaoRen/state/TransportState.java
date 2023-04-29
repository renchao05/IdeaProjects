package com.chaoRen.state;

public class TransportState implements LogisticsState{
    @Override
    public void doAction(JdLogistics context) {
        System.out.println("商品正在运往南通分拨中心。。");
    }
}
