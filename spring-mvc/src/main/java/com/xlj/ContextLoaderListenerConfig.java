package com.xlj;

import com.xlj.web.domain.repository.UserRepository;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactoryBean;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.xlj.web"})
@PropertySource({
        "classpath:properties/mysql.properties"
        ,"classpath:properties/activemq.properties"})
@EnableJpaRepositories(
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean"
        ,transactionManagerRef = "dataSourceTransactionManager"
        ,basePackages = {"com.xlj.web.domain.repository"}
)
public class ContextLoaderListenerConfig {

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory(
            @Value("${broker}") String broker
    )
    {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory();

        activeMQConnectionFactory.setBrokerURL(broker);

        return activeMQConnectionFactory;
    }

    @Bean
    public Connection activeConnectionFromActiveMQConnectionFactory(ActiveMQConnectionFactory activeMQConnectionFactory)
    {
        try {
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.setExceptionListener(new ExceptionListener() {
                @Override
                public void onException(JMSException exception) {
                    System.out.println("------------------------------------activeMQSession");
                    exception.printStackTrace();
                }
            });
            return connection;
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public PooledConnectionFactory pooledConnectionFactory(ActiveMQConnectionFactory connectionFactory)
    {
        PooledConnectionFactory pooledConnectionFactory =
                new PooledConnectionFactory();

        pooledConnectionFactory.setConnectionFactory(connectionFactory);

        return pooledConnectionFactory;
    }

    @Bean
    public PooledConnectionFactoryBean pooledConnectionFactoryBean(ActiveMQConnectionFactory connectionFactory)
    {
        PooledConnectionFactoryBean pooledConnectionFactoryBean =
                new PooledConnectionFactoryBean();

        pooledConnectionFactoryBean.setConnectionFactory(connectionFactory);

        return pooledConnectionFactoryBean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter
    )
    {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xlj.web.domain.entity");

        return localContainerEntityManagerFactoryBean;
    }

//    @Bean
//    public LocalEntityManagerFactoryBean localEntityManagerFactoryBean()
//    {
//        LocalEntityManagerFactoryBean localEntityManagerFactoryBean =
//                new LocalEntityManagerFactoryBean();
//
//        return localEntityManagerFactoryBean;
//    }

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
            @Value("${driver}") String driver,
            @Value("${url}") String url,
            @Value("${username}") String username,
            @Value("${password}")  String password
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
