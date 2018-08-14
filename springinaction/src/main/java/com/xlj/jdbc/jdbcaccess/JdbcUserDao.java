package com.xlj.jdbc.jdbcaccess;


import com.xlj.jdbc.daointerfaces.IUserDao;
import com.xlj.jdbc.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDao implements IUserDao {

    private static final String CMD_INSERT =
            "insert into user(name, age, sex) values(?, ?, ?)";

    private static final String CMD_UPDATE =
            "update user set name=?, age=?, sex=? where id=?";

    private static final String CMD_DELETE =
            "delete user where id=?";

    private static final String CMD_SELECTALL =
            "select * from user";

    @Autowired
    DataSource dataSource;

    @Override
    public int addUser(User user)
    {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = -1;

        try {
            connection = this.dataSource.getConnection();

            statement = connection.prepareStatement(JdbcUserDao.CMD_INSERT);

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getSex());

            result = statement.execute() ? 1 : -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(connection, statement, null);
        }

        return result;
    }

    @Override
    public int updateUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = -1;

        try {
            connection = this.dataSource.getConnection();

            statement = connection.prepareStatement(JdbcUserDao.CMD_UPDATE);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getSex());
            statement.setInt(4, user.getId());

            result = statement.execute() ? 1 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBHelper.closeAll(connection, statement, null);
        }

        return result;
    }

    @Override
    public int deleteUser(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = -1;

        try {
            connection = this.dataSource.getConnection();

            statement = connection.prepareStatement(JdbcUserDao.CMD_DELETE);
            statement.setInt(0, id);

            result = statement.execute() ? 1 : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBHelper.closeAll(connection, statement, null);
        }

        return result;
    }

    @Override
    public List<User> getUsers() {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<User> list = new ArrayList<>();

        try {
            connection = this.dataSource.getConnection();
            statement = connection.prepareStatement(JdbcUserDao.CMD_SELECTALL);

            resultSet = statement.executeQuery();

            User user = null;

            while (resultSet.next())
            {
                user = new User();

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));

                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBHelper.closeAll(connection, statement, resultSet);
        }

        return list;
    }

}