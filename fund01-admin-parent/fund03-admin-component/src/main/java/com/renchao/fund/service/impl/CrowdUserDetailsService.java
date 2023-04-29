package com.renchao.fund.service.impl;

import com.renchao.fund.entity.Admin;
import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;
import com.renchao.fund.exception.LoginAcctAlreadyInUseException;
import com.renchao.fund.exception.LoginFailedException;
import com.renchao.fund.service.AdminService;
import com.renchao.fund.service.AuthService;
import com.renchao.fund.service.RoleService;
import com.renchao.fund.util.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class CrowdUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据 username 查询 admin
        Admin admin = adminService.getAdminByUsername(username);
        if (admin == null) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 根据 用户 id 查询角色
        List<Role> roles = roleService.getAdminAssignRole(admin.getId());
        HashSet<Auth> auths = new HashSet<>();
        // 遍历角色 查询对于的权限。去重，需要重写 Auth 的 hash 和 equals 方法
        for (Role role : roles) {
            List<Integer> authsId = roleService.getRoleAssignAuth(role.getId());
            List<Auth> as = authService.getAuthsByRoles(authsId);
            auths.addAll(as);
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        // 封装角色
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        // 封装权限
        for (Auth auth : auths) {
            if (!Objects.equals(auth.getName(), "")) {
                authorities.add(new SimpleGrantedAuthority(auth.getName()));
            }
        }
        return new SecurityAdmin(admin, authorities);
    }
}
