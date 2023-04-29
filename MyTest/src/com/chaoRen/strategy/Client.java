package com.chaoRen.strategy;

public class Client {
    public static void main(String[] args) {
        TrafficFeeCalculator calculator = new TrafficFeeCalculator();

        System.out.printf("乘坐公交车到天津之眼的花费为：%d块人民币%n",
                calculator.goToTianJinEye(new ByBus(), 10));

        System.out.printf("乘坐滴滴快车到天津之眼的花费为：%d块人民币%n",
                calculator.goToTianJinEye(new ByDiDiExpress(), 10));

        System.out.printf("骑共享单车到天津之眼的花费为：%d块人民币%n",
                calculator.goToTianJinEye(new BySharedBicycle(), 10));
    }
}

