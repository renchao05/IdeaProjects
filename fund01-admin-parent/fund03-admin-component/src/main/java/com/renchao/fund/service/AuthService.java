package com.renchao.fund.service;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;

import java.util.List;

public interface AuthService {
    List<Auth> getAllAuth();

    List<Auth> getAuthsByRoles(List<Integer> rolesId);
}
