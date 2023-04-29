package com.renchao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.renchao.springcloud.entities.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handleException1(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息...方法1...CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息...方法2...CustomerBlockHandler");
    }
}
