package com.renchao.springcloud.service;

import com.renchao.springcloud.entities.CommonResult;
import com.renchao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${service-url.user-service}",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/payment/{id}")
    CommonResult<Payment> payment(@PathVariable("id") Long id);
}
