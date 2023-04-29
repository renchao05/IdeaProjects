package com.renchao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.renchao.springcloud.entities.CommonResult;
import com.renchao.springcloud.entities.Payment;
import com.renchao.springcloud.myhandler.CustomerBlockHandler;
import com.renchao.springcloud.myhandler.FallbackHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController
{
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200,"按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444,exception.getClass().getCanonicalName()+"  服务不可用");
    }

    public CommonResult fallbackHandle() {
        return new CommonResult(444,"  服务不可用");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "byResource",    // 资源名
            blockHandlerClass = CustomerBlockHandler.class, // 限流处理类
            blockHandler = "handleException1",  // 指定限流处理类的哪个方法
            fallbackClass = FallbackHandler.class, // 异常处理类
            fallback = "fallbackHandle2")   // 指定异常处理类的哪个方法
    public CommonResult customerBlockHandler() {
        int a = 4 / 0;
        return new CommonResult(200,"按客户自定义限流处理逻辑");
    }
}
