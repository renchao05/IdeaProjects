package com.chaoRen.factory;


/**
 * 抽象工厂模式
 */
public class Client_AbstractFactory {

    public static void main(String[] args) {
        //现在，需要小米屏幕

        //1、找屏幕工厂（创建屏幕工厂对象）
        AbstractFactory af = new ScreenFactory();

        //2、屏幕工厂里生产出小米的屏幕
        XiaomiComponent xiaomiScreen = af.createXiaomi();

        //3、得到小米屏幕
        xiaomiScreen.produceComponent();

        //若需要其他产品，操作类似
    }
}
