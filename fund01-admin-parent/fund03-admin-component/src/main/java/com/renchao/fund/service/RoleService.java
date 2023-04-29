package com.renchao.fund.service;

import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;

import java.util.List;


public interface RoleService {

    PageInfo<Role> getRolesPage(String keyword, Integer pageNum, Integer pageSize);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(List<Integer> ids);

    List<Role> getAdminAssignRole(Integer id);

    List<Role> getAdminNotAssignRole(Integer id);

    void saveAdminAssignRole(Integer adminId, Integer[] rolesId);

    List<Integer> getRoleAssignAuth(Integer roleId);

    void saveRoleAssignAuth(Integer roleId, List<Integer> authsId);
}
