package com.xlj.security;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:META-INF/properties/mysql.properties")
@EnableJpaRepositories(
        basePackages = {"com.xlj.security"}
        ,entityManagerFactoryRef = "localContainerEntityManagerFactoryBean"
        ,transactionManagerRef = "dataSourceTransactionManager")
@EnableGlobalMethodSecurity(
        securedEnabled = true
        ,jsr250Enabled = true)
public class Config extends GlobalMethodSecurityConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter
    )
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.security");
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVerdorAdapter()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =
                new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public DataSource dbcp(
            @Value("${driver}") String driver,
            @Value("${url}") String url,
            @Value("${username}") String username,
            @Value("${password}") String password
    )
    {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setPassword(password);
        basicDataSource.setUsername(username);
        basicDataSource.setUrl(url);
        basicDataSource.setDriverClassName(driver);

        return basicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public App app()
    {
        return new App();
    }

}