package com.renchao.fund.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Admin;
import com.renchao.fund.entity.AdminExample;
import com.renchao.fund.exception.LoginAcctAlreadyInUseException;
import com.renchao.fund.exception.LoginFailedException;
import com.renchao.fund.mapper.AdminMapper;
import com.renchao.fund.service.AdminService;
import com.renchao.fund.util.CrowdConstant;
import com.renchao.fund.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveAdmin(Admin admin) {
        //对密码进行加密
        String encode = passwordEncoder.encode(admin.getUserPswd());
        admin.setUserPswd(encode);

        //设置 用户创建时间
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createTime = LocalDateTime.now().format(pattern);
        admin.setCreateTime(createTime);

        try {
            adminMapper.insert(admin);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            //捕获异常交由自定义异常，然后再由异常处理机制，主要是唯一约束
            throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
        }
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {
        // 1.根据登录账号查询 Admin 对象
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andLoginAcctEqualTo(loginAcct);
        List<Admin> adminList = adminMapper.selectByExample(example);

        // 1、如果没有查询到用户抛异常
        if (adminList == null || adminList.size() == 0) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 2、如果查询到的用户不是唯一抛异常
        if (adminList.size() > 1) {
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }

        Admin admin = adminList.get(0);
        // 3、再次判断 admin 是否为空，如果为空，抛异常
        if (admin == null) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

        // 4、验证密码
        String userPswdFrom = CrowdUtil.md5(userPswd);
        if (!Objects.equals(admin.getUserPswd(), userPswdFrom)) {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 5、如果全部正常，返回 admin
        return admin;
    }

    @Override
    public PageInfo<Admin> getUserPage(String keyword, Integer pageNum, Integer pageSize) {
        // 1.开启分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 2.查询 Admin 数据,admins 运行类型是 page
        List<Admin> admins = adminMapper.selectByKeyword(keyword);
        //3.为了方便页面使用将 admins 封装为 PageInfo 返回
        return new PageInfo<>(admins,5);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            //捕获异常交由自定义异常，然后再由异常处理机制，主要是唯一约束
            throw new LoginAcctAlreadyInUseException(CrowdConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
        }
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.selectByUsername(username);
    }

}
