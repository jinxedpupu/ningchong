package com.cdvtc.ningchong.dao;

import com.cdvtc.ningchong.model.User;

public interface NingchongDao {

    /**
     *@return 用户对象，null表示未找到
     * 根据用户账号和密码，获取用户信息
     */
    User getUser(String userzhanghao, String userpassword);

    /**
     * 添加用户（用户注册）
     */
    void addUser(User user);

    /**
     * 用户充值
     */
    void adduseryue(User user);
}
