package com.xlj.jaxws;

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
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean"
        ,transactionManagerRef = "dataSourceTransactionManager"
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
        localContainerEntityManagerFactoryBean.setJtaDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.jaxws");

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter hibernateJpaVendorAdpter()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter =
                new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);

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

        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }
}
