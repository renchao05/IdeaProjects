package com.chaoRen.service;

import com.chaoRen.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user 用户
     */
    public int registerUser(User user);

    /**
     * 登陆
     * @param user 用户
     * @return 返回用户信息
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username 用户名
     * @return 返回true表示用户名存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
