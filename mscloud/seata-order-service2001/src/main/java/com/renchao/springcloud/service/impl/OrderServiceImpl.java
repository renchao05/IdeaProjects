package com.renchao.springcloud.service.impl;

import com.renchao.springcloud.dao.OrderDao;
import com.renchao.springcloud.domain.Order;
import com.renchao.springcloud.service.AccountService;
import com.renchao.springcloud.service.OrderService;
import com.renchao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional/*(name = "renchao_tx_group",rollbackFor = Exception.class)*/
    public void create(Order order) {
        log.info("开始创建订单。。。");
        orderDao.create(order);

        log.info("开始调整库存。。。");
        storageService.updateStorage(order);

        log.info("开始扣钱。。。");
        accountService.deductMoney(order.getUserId(), order.getMoney());

        int i = 9/0;
        log.info("开始调整订单状态。。。");
        orderDao.update(order.getUserId(),0);
    }
}
