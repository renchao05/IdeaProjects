package com.renchao.gmall.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.renchao.gmall.bean.UserAddress;
import com.renchao.gmall.service.OrderService;
import com.renchao.gmall.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Reference
	UserService userService;

	@Override
	@HystrixCommand(fallbackMethod = "hello")
	public List<UserAddress> initOrder(String userId) {
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		System.out.println(addressList);
		return addressList;
	}

	public List<UserAddress> hello(String userId) {
		return Collections.singletonList(new UserAddress(88, "测试地址", "88", "测试老师", "123456", "Y"));
	}
}
