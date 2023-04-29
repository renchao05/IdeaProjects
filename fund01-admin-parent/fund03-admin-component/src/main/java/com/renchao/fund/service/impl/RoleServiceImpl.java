package com.renchao.fund.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Admin;
import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;
import com.renchao.fund.entity.RoleExample;
import com.renchao.fund.mapper.RoleMapper;
import com.renchao.fund.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageInfo<Role> getRolesPage(String keyword, Integer pageNum, Integer pageSize) {
        // 1.开启分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 2.查询 Admin 数据,admins 运行类型是 page
        List<Role> roles = roleMapper.selectByKeyword(keyword);
        //3.为了方便页面使用将 admins 封装为 PageInfo 返回
        return new PageInfo<>(roles, 5);
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void deleteRole(List<Integer> ids) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        roleMapper.deleteByExample(example);
    }

    @Override
    public List<Role> getAdminAssignRole(Integer adminId) {
        return roleMapper.selectAdminAssignRole(adminId);
    }

    @Override
    public List<Role> getAdminNotAssignRole(Integer adminId) {
        return roleMapper.selectAdminNotAssignRole(adminId);
    }

    @Override
    public void saveAdminAssignRole(Integer adminId, Integer[] rolesId) {
        roleMapper.deleteAdminAssignRole(adminId);
        if (rolesId != null) {
            roleMapper.insertAdminAssignRole(adminId, rolesId);
        }
    }

    @Override
    public List<Integer> getRoleAssignAuth(Integer roleId) {
        return roleMapper.selectRoleAssignAuth(roleId);
    }

    @Override
    public void saveRoleAssignAuth(Integer roleId, List<Integer> authsId) {
        // 先把以前的全部删除
        roleMapper.deleteRoleAssignAuth(roleId);
        // 保存新的
        if (authsId != null && authsId.size() > 0) {
            roleMapper.insertRoleAssignAuth(roleId, authsId);
        }
    }


}
