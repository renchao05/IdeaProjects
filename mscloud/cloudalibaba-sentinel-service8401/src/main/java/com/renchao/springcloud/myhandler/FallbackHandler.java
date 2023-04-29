package com.renchao.springcloud.myhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.renchao.springcloud.entities.CommonResult;

public class FallbackHandler {
    public static CommonResult fallbackHandle1(Throwable exception){
        return new CommonResult(2020,"自定义的异常处理逻辑...方法1...FallbackHandler");
    }

    public static CommonResult fallbackHandle2(Throwable exception){
        return new CommonResult(2020,"自定义的异常处理逻辑...方法2...FallbackHandler");
    }
}
