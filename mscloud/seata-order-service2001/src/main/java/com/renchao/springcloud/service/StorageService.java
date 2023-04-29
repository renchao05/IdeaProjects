package com.renchao.springcloud.service;

import com.renchao.springcloud.domain.CommonResult;
import com.renchao.springcloud.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient("seata-storage-service") // 使用openfeign
public interface StorageService {

    @PostMapping("/updateStorage")
    CommonResult<String> updateStorage(@RequestBody Order order);
}
