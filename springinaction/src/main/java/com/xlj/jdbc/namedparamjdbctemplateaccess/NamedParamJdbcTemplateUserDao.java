package com.xlj.jdbc.namedparamjdbctemplateaccess;

import com.xlj.jdbc.daointerfaces.IUserDao;
import com.xlj.jdbc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamedParamJdbcTemplateUserDao implements IUserDao {

    private static final String CMD_INSERT =
            "insert into user(name, age, sex) values(:name, :age, :sex)";

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int addUser(User user) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("age", user.getAge());
        params.put("sex", user.getSex());

        return this.namedParameterJdbcTemplate.update(NamedParamJdbcTemplateUserDao.CMD_INSERT, params);
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
