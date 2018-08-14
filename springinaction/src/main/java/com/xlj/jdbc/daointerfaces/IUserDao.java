package com.xlj.jdbc.daointerfaces;

import com.xlj.jdbc.models.User;

public interface IUserDao {


    /**
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     *
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     *
     * @return
     */
    java.util.List<User> getUsers();
}
