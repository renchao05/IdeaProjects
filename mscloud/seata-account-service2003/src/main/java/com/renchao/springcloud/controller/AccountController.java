package com.renchao.springcloud.controller;

import com.renchao.springcloud.domain.CommonResult;
import com.renchao.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PutMapping("/deductMoney")
    CommonResult<String> deductMoney(Long userId, BigDecimal money) {
//        int i = 4 / 0;
        accountService.deductMoney(userId, money);

        return new CommonResult<>(200, "OK", "扣钱成功！");
    }
}
