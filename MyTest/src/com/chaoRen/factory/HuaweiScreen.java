package com.chaoRen.factory;


/**
 * 具体产品--华为屏幕
 */
class HuaweiScreen implements HuaweiComponent{

    @Override
    public void produceComponent() {
        System.out.println("华为屏幕生产完毕！");

    }

}
