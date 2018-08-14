package com.xlj.security;

import com.xlj.security.interfaces.IUserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RolesAllowed;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    IUserDao userDao;

    @org.junit.Test
    @RolesAllowed({"ROLE_USER_"})
    public void test()
    {
        System.out.println(this.userDao);

        System.out.println(this.userDao.findAll());
    }
}
