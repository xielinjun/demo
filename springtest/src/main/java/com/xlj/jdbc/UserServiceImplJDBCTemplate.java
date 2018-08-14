package com.xlj.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

public class UserServiceImplJDBCTemplate implements IUserService {

    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    @Override
    public int saveUser(User user) {
        return this.jdbcTemplate.update(
                "insert into user(name, age, sex) values(?, ?, ?)",
                new Object[]{user.getName(), user.getAge(), user.getSex()},
                new int[]{ Types.VARCHAR, Types.INTEGER, Types.VARCHAR }
        );
    }

    @Override
    public List<User> getUsers() {
        List<User> listUsers = this.jdbcTemplate.query(
                "select * from user",
                new UserRowMapper()
        );

        return listUsers;
    }
}
