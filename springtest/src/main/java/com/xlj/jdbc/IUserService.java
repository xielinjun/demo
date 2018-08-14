package com.xlj.jdbc;

public interface IUserService {

    int saveUser(User user);

    java.util.List<User> getUsers();

}
