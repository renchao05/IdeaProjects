package com.renchao.springcloud.service.impl;

import com.renchao.springcloud.dao.AccountDao;
import com.renchao.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void deductMoney(Long userId, BigDecimal money) {
        accountDao.updateMoney(userId,money);
    }
}
