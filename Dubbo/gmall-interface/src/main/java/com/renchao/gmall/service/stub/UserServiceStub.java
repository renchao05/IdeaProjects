package com.renchao.gmall.service.stub;

import com.renchao.gmall.bean.UserAddress;
import com.renchao.gmall.service.UserService;
import com.sun.deploy.util.StringUtils;

import java.util.List;

public class UserServiceStub implements UserService {
    private final UserService userService;
    // 自动注入属性。
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("测试Stub=========");
        if (userId == null || userId.length() == 0) {
            return null;
        }
        return userService.getUserAddressList(userId);
    }
}
