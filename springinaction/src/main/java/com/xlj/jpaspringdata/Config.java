package com.xlj.jpaspringdata;

import com.xlj.jpaspringdata.daointerfaces.IUserDao;
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

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:META-INF/properties/mysql.properties")
@EnableJpaRepositories(
        basePackages = {"com.xlj.jpaspringdata.daointerfaces"},
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
        transactionManagerRef = "dataSourceTransactionManager")
//@EnableJpaRepositories(repositoryBaseClass = IUserDao.class)
public class Config {

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter)
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.jpaspringdata.model");

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdapter()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =
                new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return hibernateJpaVendorAdapter;
    }

    @Bean
    public DataSource dbcp(
           @Value("${url}") String url,
           @Value("${driver}") String driver,
           @Value("${username}") String username,
           @Value("${password}") String password)
    {
        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setUrl(url);
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return  basicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }


}
