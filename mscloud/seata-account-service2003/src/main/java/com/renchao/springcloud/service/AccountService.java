package com.renchao.springcloud.service;


import java.math.BigDecimal;

public interface AccountService {
    void deductMoney(Long userId,  BigDecimal money);
}
