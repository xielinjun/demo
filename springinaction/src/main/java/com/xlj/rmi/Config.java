package com.xlj.rmi;

import com.xlj.rmi.serviceinterfaces.IProducter;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:META-INF/properties/mysql.properties")
@EnableJpaRepositories(
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean"
        ,transactionManagerRef = "dataSourceTransactionManager"
        ,basePackages = {"com.xlj.rmi.interfaces"}
        )
public class Config {

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            JpaVendorAdapter jpaVendorAdapter,
            DataSource dataSource
    )
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.rmi.model");

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdaptor()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =
                new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        hibernateJpaVendorAdapter.setShowSql(true);

        return  hibernateJpaVendorAdapter;
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

        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager(dataSource);

        return dataSourceTransactionManager;
    }

}