package com.chaoren.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoren.mybatisx.bean.User;
import com.chaoren.mybatisx.service.UserService;
import com.chaoren.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author KEFU
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-03-22 22:32:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




