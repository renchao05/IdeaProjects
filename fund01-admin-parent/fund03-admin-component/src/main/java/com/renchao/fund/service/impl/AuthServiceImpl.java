package com.renchao.fund.service.impl;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.AuthExample;
import com.renchao.fund.entity.Role;
import com.renchao.fund.mapper.AuthMapper;
import com.renchao.fund.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAllAuth() {
        return authMapper.selectByExample(null);
    }

    @Override
    public List<Auth> getAuthsByRoles(List<Integer> rolesId) {
        if (rolesId == null || rolesId.size() == 0) {
            return new ArrayList<>();
        }
        AuthExample example = new AuthExample();
        AuthExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(rolesId);
        return authMapper.selectByExample(example);
    }


}
