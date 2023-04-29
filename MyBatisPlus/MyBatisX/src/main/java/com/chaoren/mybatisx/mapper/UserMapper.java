package com.chaoren.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chaoren.mybatisx.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author KEFU
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-03-22 22:32:32
* @Entity com.chaoren.mybatisx.bean.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<User> searchAllById(@Param("id") Long id);

    List<User> selectUsernameAndAgeById(@Param("id") Long id);

    List<User> selectAllOrderByAgeDesc();

    List<User> selectAllOrderByAgeAsc();

    int deleteByIdAndUsername(@Param("id") Long id, @Param("username") String username);

    int insertSelective(User user);

    int updateAgeAndEmailById(@Param("age") Integer age, @Param("email") String email, @Param("id") Long id);

}




