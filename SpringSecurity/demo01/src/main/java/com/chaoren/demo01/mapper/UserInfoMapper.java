package com.chaoren.demo01.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoren.demo01.bean.Menu;
import com.chaoren.demo01.bean.Role;
import com.chaoren.demo01.bean.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<Users> {
    /**
     * 根据用户 Id 查询用户角色
     * @param userId
     * @return
     */
    List<Role> selectRoleByUserId(Long userId);
    /**
     * 根据用户 Id 查询菜单
     * @param userId
     * @return
     */
    List<Menu> selectMenuByUserId(Long userId);

    Users selectByUsername(@Param("username") String username);

}
