package com.renchao.springcloud.service.impl;

import com.renchao.springcloud.dao.StorageDao;
import com.renchao.springcloud.domain.Order;
import com.renchao.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;

    @Override
    public void updateStorage(Order order) {
        storageDao.updateStorage(order.getProductId(),order.getCount());
    }
}
