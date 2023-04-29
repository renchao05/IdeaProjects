package com.chaoren.demo01.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chaoren.demo01.bean.Users;
import com.chaoren.demo01.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("userDetailsService")
public class SqlUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Users users = usersMapper.selectOne(queryWrapper);
        if (users == null) {
            throw new UsernameNotFoundException("用户不存在！！");
        }
        System.out.println(users);
        List<GrantedAuthority> auths = AuthorityUtils
                .commaSeparatedStringToAuthorityList("admins,ROLE_admin");
        return new User(users.getUsername(),users.getPassword(),auths);
    }
}
