package com.renchao.springcloud.service;

import com.renchao.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Service
@FeignClient("seata-account-service") // 使用openfeign
public interface AccountService {

    @PutMapping("/deductMoney")
    CommonResult<String> deductMoney(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
