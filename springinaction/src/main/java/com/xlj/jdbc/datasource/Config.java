package com.xlj.jdbc.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("META-INF/properties/mysql.properties")
public class Config {

//    @Bean
//    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
//    {
//        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
//                new PropertySourcesPlaceholderConfigurer();
//        propertySourcesPlaceholderConfigurer.setLocations(
//                new ClassPathResource("META-INF/properties/mysql.properties")
//        );
//
//        return propertySourcesPlaceholderConfigurer;
//    }

    @Bean
    @Profile("dev")
    public DataSource dbcp(
            @Value("${driver}") String driverclass,
            @Value("${url}") String url,
            @Value("${username}") String user,
            @Value("${password}") String password)
    {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverclass);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    @Profile("test")
    public DataSource embedded()
    {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

}
