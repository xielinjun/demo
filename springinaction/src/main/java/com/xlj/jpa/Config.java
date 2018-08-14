package com.xlj.jpa;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:META-INF/properties/mysql.properties")
public class Config {

    @Bean
//    @Qualifier("localEntityManagerFactoryBean")
    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean(JpaVendorAdapter jpaVendorAdapter)
    {
        LocalEntityManagerFactoryBean localEntityManagerFactoryBean =
                new LocalEntityManagerFactoryBean();

        localEntityManagerFactoryBean.setPersistenceUnitName("userPU");
        localEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        return localEntityManagerFactoryBean;
    }

    @Bean
//    @Qualifier("localContainerEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            @Value("#{dbcp1}") DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter)
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.jpa.model");

        return localContainerEntityManagerFactoryBean;
    }

//    @Bean
//    public DataSource dbcp(
//            @Value("${driver}") String driver,
//            @Value("${url}") String url,
//            @Value("${user11name}") String username,
//            @Value("${password}") String password)
//    {
//        BasicDataSource basicDataSource = new BasicDataSource();
//
//        basicDataSource.setDriverClassName(driver);
//        basicDataSource.setUrl(url);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);
//
//        return basicDataSource;
//    }

    @Bean
    public DataSource dbcp1(
            @Value("${driver}") String driver,
            @Value("${url}") String url,
            @Value("${username}") String username,
            @Value("${password}") String password)
    {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdapter()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
//        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
}
