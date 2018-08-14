package com.xlj.jdbc;

import com.xlj.jdbc.daointerfaces.IUserDao;
import com.xlj.jdbc.jdbcaccess.JdbcUserDao;
import com.xlj.jdbc.jdbctemplateaccess.JdbcTemplateUserDao;
import com.xlj.jdbc.namedparamjdbctemplateaccess.NamedParamJdbcTemplateUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@Import(com.xlj.jdbc.datasource.Config.class)
public class Config {

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource)
    {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplateUserDao jdbcTemplateUserDao()
    {
        return new JdbcTemplateUserDao();
    }

    @Bean
    public IUserDao jdbcUserDao()
    {
        return new JdbcUserDao();
    }

    @Bean
    public NamedParamJdbcTemplateUserDao namedParamJdbcTemplateUserDao()
    {
        return new NamedParamJdbcTemplateUserDao();
    }

}
