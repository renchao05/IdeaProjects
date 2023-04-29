package com.chaoRen.factory;

/**
 * 具体工厂--电池工厂
 */
class BatteryFactory implements AbstractFactory{

    //小米电池
    @Override
    public XiaomiComponent createXiaomi() {
        return new XiaomiBattery();
    }

    //华为电池
    @Override
    public HuaweiComponent createHuawei() {
        return new HuaweiBattery();
    }


}
