package com.renchao.fund.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Role;
import com.renchao.fund.service.RoleService;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
//    @PreAuthorize("hasAuthority('role:get')")
    public ResultEntity<PageInfo<Role>> getRole(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

        PageInfo<Role> rolesPage = roleService.getRolesPage(keyword, pageNum, pageSize);

        return ResultEntity.successWithData(rolesPage);
    }


    @PostMapping
    @PreAuthorize("hasAuthority('role:add')")
    public ResultEntity<PageInfo<Role>> saveRole(Role role) {

        roleService.saveRole(role);

        return ResultEntity.successWithoutData();
    }

    @PutMapping
    public ResultEntity<PageInfo<Role>> updateRole(Role role) {

        roleService.updateRole(role);

        return ResultEntity.successWithoutData();
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('role:delete')")
    public ResultEntity<PageInfo<Role>> deleteRole(@RequestBody List<Integer> ids) {
        roleService.deleteRole(ids);
        return ResultEntity.successWithoutData();
    }

}
