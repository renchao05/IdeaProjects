package com.renchao.fund.service;

import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Admin;

import java.util.List;

public interface AdminService {

    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    PageInfo<Admin> getUserPage(String keyword, Integer pageNum, Integer pageSize);

    Admin getAdminById(Integer id);

    void updateAdmin(Admin admin);

    void deleteAdmin(Integer id);

    Admin getAdminByUsername(String username);
}
