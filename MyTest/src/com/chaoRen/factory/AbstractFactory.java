package com.chaoRen.factory;


/**
 * 抽象工厂，这里生产一些手机的零件
 */
interface AbstractFactory{
    //小米零件
    XiaomiComponent createXiaomi();

    //华为零件
    HuaweiComponent createHuawei();
}