package com.xlj.jdbc.jdbctemplateaccess;

import com.xlj.jdbc.daointerfaces.IUserDao;
import com.xlj.jdbc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateUserDao implements IUserDao, RowMapper<User>, Serializable {

    private static final long serialVersionUID = -1027122260173654810L;

    private static final String CMD_INSERT =
            "insert into user(name, age, sex) values(?, ?, ?)";

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String CMD_UPDATE =
            "update user set name=?, age=?, sex=? where id=?";

    private static final String CMD_DELETE =
            "delete user where id=?";

    private static final String CMD_SELECTALL =
            "select * from user";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addUser(User user) {

        return this.jdbcTemplate.update(JdbcTemplateUserDao.CMD_INSERT,
                new Object[]{user.getName(), user.getAge(), user.getSex()});
    }

    @Override
    public int updateUser(User user) {
        return this.jdbcTemplate.update(JdbcTemplateUserDao.CMD_UPDATE,
                new Object[]{user.getName(), user.getAge(), user.getAge(), user.getId()});
    }

    @Override
    public int deleteUser(int id) {
        return this.jdbcTemplate.update(JdbcTemplateUserDao.CMD_DELETE,
                new Object[]{id});
    }

    @Override
    public List<User> getUsers() {
        return this.jdbcTemplate.query(JdbcTemplateUserDao.CMD_SELECTALL,
                this);

//        return this.jdbcTemplate.query(JdbcTemplateUserDao.CMD_SELECTALL,
//                this::mapRow);
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("sex"));

        return user;
    }
}
