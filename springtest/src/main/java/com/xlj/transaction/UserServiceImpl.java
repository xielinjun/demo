package com.xlj.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

public class UserServiceImpl implements IUserService {

    JdbcTemplate jdbcTemplate = null;

    DataSource dataSource = null;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void save(User user) throws Exception {

        this.jdbcTemplate.update("insert into user(name, age, sex) values(?, ?, ?)",
                new Object[]{user.name, user.age, user.sex},
                new int[]{Types.VARCHAR, Types.INTEGER, Types.VARCHAR});

        throw new RuntimeException("save tset");
    }

}
