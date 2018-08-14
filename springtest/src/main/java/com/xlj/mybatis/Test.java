package com.xlj.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test {

    static SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

    public static void main(String[] args) {

        SqlSession sqlSession = Test.sqlSessionFactory.openSession();

        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        User user  = userMapper.getUser(1);
    }

}
