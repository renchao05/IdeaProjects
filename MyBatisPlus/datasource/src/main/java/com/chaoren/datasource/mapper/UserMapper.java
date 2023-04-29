package com.chaoren.datasource.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoren.datasource.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
