package com.chaoRen.strategy;

public class TrafficFeeCalculator {
    public int goToTianJinEye(CalculateStrategy strategy,int distance){
        return strategy.calculateTrafficFee(distance);
    }
}
