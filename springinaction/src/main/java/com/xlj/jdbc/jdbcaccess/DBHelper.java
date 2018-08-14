package com.xlj.jdbc.jdbcaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    /**
     *
     * @param connection
     */
    public static void closeConnection(Connection connection)
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param statement
     */
    public  static void closeStatement(Statement statement)
    {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param resultSet
     */
    public static void closeResultSet(ResultSet resultSet)
    {
        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param connection
     * @param statement
     * @param resultSet
     */
    public  static void closeAll(Connection connection, Statement statement, ResultSet resultSet)
    {
        if(resultSet != null) {
            DBHelper.closeResultSet(resultSet);
        }

        if(statement != null) {
            DBHelper.closeStatement(statement);
        }

        if(connection != null) {
            DBHelper.closeConnection(connection);
        }
    }

}
