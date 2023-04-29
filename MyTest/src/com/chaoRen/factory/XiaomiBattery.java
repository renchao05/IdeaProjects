package com.chaoRen.factory;


/**
 * 具体产品--小米电池
 */
class XiaomiBattery implements XiaomiComponent{

    @Override
    public void produceComponent() {
        System.out.println("小米电池生产完毕！");

    }

}
