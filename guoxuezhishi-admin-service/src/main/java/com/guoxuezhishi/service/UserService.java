package com.guoxuezhishi.service;

import com.guoxuezhishi.pojo.wechat.Users;

public interface UserService {
    /**
     * 判断用户名是否存在
     */
    public boolean queryUserNameIsExist(String username);

    /**
     * 保存用户（用户注册）
     */
    public void saveUser(Users user);

    /**
     * 用户登录，根据用户名和密码查询用户
     */
    public Users queryUserForLogin(String username, String password);

    /**
     * 用户修改信息
     */
    public void updateUserInfo(Users users);

    /**
     * 查询用户信息
     */
    public Users queryUserInfo(String userId);
}
