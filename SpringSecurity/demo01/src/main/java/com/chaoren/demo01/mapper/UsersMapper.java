package com.chaoren.demo01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoren.demo01.bean.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper extends BaseMapper<Users> {
}
