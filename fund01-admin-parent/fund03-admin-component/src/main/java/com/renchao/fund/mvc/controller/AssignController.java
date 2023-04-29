package com.renchao.fund.mvc.controller;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.entity.Role;
import com.renchao.fund.service.AuthService;
import com.renchao.fund.service.RoleService;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/assign")
public class AssignController {

    @Autowired
    private RoleService roleService;


    @GetMapping("/role/page")
    public String toAssignRolePage(@RequestParam("id") Integer id,
                                   HttpServletRequest request) {

        // 记录来源页面
        String referer = request.getHeader("Referer");
        request.setAttribute("referer",referer);

        List<Role> roles = roleService.getAdminAssignRole(id);
        request.setAttribute("roles", roles);

        List<Role> notAssignRoles = roleService.getAdminNotAssignRole(id);
        request.setAttribute("nRoles", notAssignRoles);

        return "assign/role-page";
    }

    @PostMapping("/role")
    public String saveAdminAssignRole(@RequestParam(value = "rolesId",required = false) Integer[] rolesId,
                                      @RequestParam("adminId") Integer adminId,
                                      @RequestParam("referer") String referer) {

        roleService.saveAdminAssignRole(adminId,rolesId);

        return "redirect:" + referer;
    }

    @GetMapping("/auth")
    @ResponseBody
    public ResultEntity<List<Integer>> getRoleAssignAuth(@RequestParam("roleId") Integer roleId) {

        List<Integer> auths = roleService.getRoleAssignAuth(roleId);

        return ResultEntity.successWithData(auths);
    }

    @PostMapping("/auth")
    @ResponseBody
    public ResultEntity<String> saveRoleAssignAuth(@RequestBody Map<String,List<Integer>> map) {

        Integer roleId = map.get("roleId").get(0);
        List<Integer> authsId = map.get("authIdArray");

        roleService.saveRoleAssignAuth(roleId,authsId);

        return ResultEntity.successWithoutData();
    }

}
