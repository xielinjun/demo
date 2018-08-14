package com.xlj.beanwiringhightLeve.profile;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
public class MergeProfileConfigs {

    @Bean//(destroyMethod = "shutdown")
//    @Profile("dev")
    public DataSource embeddedDataSource()
    {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        return new MysqlDataSource();
    }

    @Bean
//    @Profile("prod")
    public DataSource jndiDataSource()
    {
        JndiObjectFactoryBean jndiObjectFactoryBean =
                new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);

        return (DataSource)jndiObjectFactoryBean.getObject();
    }

}
