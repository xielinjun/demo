package com.xlj.dal;

import com.xlj.model.User;
import com.xlj.model.response.Response;

public interface IUserDAL {

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    Response<User> login(String name, String password);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Response<Integer> addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    Response<Integer> deleteUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Response<Integer> updateUser(User user);

    /**
     * 修改用户密码
     * @param id
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Response<Integer> updatePassword(String id, String oldPassword, String newPassword);
}