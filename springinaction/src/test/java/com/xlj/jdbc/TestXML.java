package com.xlj.jdbc;

import com.xlj.jdbc.daointerfaces.IUserDao;
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
@ContextConfiguration(locations = "classpath:jdbc.xml")
@ActiveProfiles("dev")
public class TestXML {

    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("jdbcUserDao")
    IUserDao userDao;

    @Autowired
    @Qualifier("jdbcTemplateUserDao")
    IUserDao userDao1;

    @Test
    public void tset()
    {
        System.out.println(this.userDao.getUsers());
    }

    @Test
    public void tsetTemplate()
    {
        System.out.println(this.userDao1.getUsers());
    }
}