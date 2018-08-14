package com.xlj.mybatis;

public interface IUserMapper {

    void insertUser(User user);

    User getUser(int id);

    java.util.List<User> getUserByName(String name);

    java.util.List<User> getUserByNameAndAge(String name, int age);


}
