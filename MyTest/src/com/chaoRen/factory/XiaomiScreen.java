package com.chaoRen.factory;


/**
 * 具体产品--小米屏幕
 */
class XiaomiScreen implements XiaomiComponent{

    @Override
    public void produceComponent() {
        System.out.println("小米屏幕生产完毕！");

    }

}
