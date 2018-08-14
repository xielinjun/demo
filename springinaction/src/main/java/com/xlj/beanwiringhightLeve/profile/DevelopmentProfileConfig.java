package com.xlj.beanwiringhightLeve.profile;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
//@Profile("dev")
public class DevelopmentProfileConfig {

    @Bean//(destroyMethod = "shutdown")
    public DataSource dataSource()
    {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        return new MysqlDataSource();
    }

}
