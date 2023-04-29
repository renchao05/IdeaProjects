package com.renchao.springcloud.controller;

import com.renchao.springcloud.domain.CommonResult;
import com.renchao.springcloud.domain.Order;
import com.renchao.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/updateStorage")
    public CommonResult<String> updateStorage(@RequestBody Order order) {
        storageService.updateStorage(order);
        return new CommonResult<>(200, "OK", "扣减库存成功！");
    }
}
