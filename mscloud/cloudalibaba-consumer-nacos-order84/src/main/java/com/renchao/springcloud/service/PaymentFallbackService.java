package com.renchao.springcloud.service;

import com.renchao.springcloud.entities.CommonResult;
import com.renchao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> payment(Long id) {
        return new CommonResult<>(444,"服务降级返回!",new Payment(id, "errorSerial......"));
    }
}
