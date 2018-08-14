package com.xlj.jdbc;


import com.xlj.jdbc.daointerfaces.IUserDao;
import com.xlj.jdbc.datasource.Config;
import com.xlj.jdbc.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.xlj.jdbc.Config.class)
@ActiveProfiles("dev")
public class TestJavaConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("jdbcUserDao")
    IUserDao userDao;

    @Autowired
    @Qualifier("jdbcTemplateUserDao")
    IUserDao userDao1;

    @Autowired()
    @Qualifier("namedParamJdbcTemplateUserDao")
    IUserDao userDao2;

    @Test
    public void test()
    {
        System.out.println(this.dataSource);
        try {
            this.dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(User user : this.userDao.getUsers())
        {
            System.out.println(user);
            user.setName("update");
            this.userDao.updateUser(user);
        }
    }

    @Test
    public void testJdbcTemplate()
    {
        for(User user : this.userDao1.getUsers())
        {
            System.out.println(user);
            user.setName("template");
            this.userDao1.updateUser(user);
        }
    }

    @Test
    public void testNamedJdbcTemplate()
    {
        System.out.println(this.userDao2);
        System.out.println(this.userDao2.addUser(new User(0,"nihao", 10, "helo")));
        System.out.println(this.userDao1.getUsers());
    }

}
