package com.chaoren.demo01.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoren.demo01.bean.Menu;
import com.chaoren.demo01.bean.Role;
import com.chaoren.demo01.bean.Users;
import com.chaoren.demo01.mapper.UserInfoMapper;
import com.chaoren.demo01.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service("userDetailsService")
public class UsersServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoMapper userInfoMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userInfoMapper.selectByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("用户不存在！！");
        }
        Long id = (long) users.getId();
        //获取到用户角色和菜单列表
        List<Role> roles = userInfoMapper.selectRoleByUserId(id);
        List<Menu> menus = userInfoMapper.selectMenuByUserId(id);

        //声明应该List<GrantedAuthority>集合
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //处理角色
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        //处理权限
        for (Menu menu : menus) {
            grantedAuthorities.add(new SimpleGrantedAuthority(menu.getPermission()));
        }

        return new User(username,users.getPassword(),grantedAuthorities);
    }
}
