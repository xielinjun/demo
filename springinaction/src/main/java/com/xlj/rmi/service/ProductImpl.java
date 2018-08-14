package com.xlj.rmi.service;

import com.xlj.rmi.interfaces.IUserDao;
import com.xlj.rmi.model.User;
import com.xlj.rmi.serviceinterfaces.IProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductImpl implements IProducter {

    @Autowired
    IUserDao userDao;

    @Override
    public List<User> getAllUser() {
        return this.userDao.findAll();
    }
}
