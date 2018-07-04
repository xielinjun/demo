package com.xlj.model;

import java.util.Date;

public class User {

    public User(){}

    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String username;
    public String password;
    public Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void showMe()
    {
        System.out.println("i am user.");
    }

    public void changeMe()
    {
        System.out.println("i am user changeme.");
    }
}
