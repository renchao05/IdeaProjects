package com.chaoRen.factory;

/**
 * 具体零件工厂--屏幕工厂
 */
class ScreenFactory implements AbstractFactory{

    //小米屏幕
    @Override
    public XiaomiComponent createXiaomi() {
        return new XiaomiScreen();
    }

    //华为屏幕
    @Override
    public HuaweiComponent createHuawei() {
        return new HuaweiScreen();
    }


}
