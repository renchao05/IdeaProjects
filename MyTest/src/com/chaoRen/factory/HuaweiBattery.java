package com.chaoRen.factory;

/**
 * 具体产品--华为电池
 */
class HuaweiBattery implements HuaweiComponent {
    @Override
    public void produceComponent() {
        System.out.println("华为电池生产完毕！");
    }
}
