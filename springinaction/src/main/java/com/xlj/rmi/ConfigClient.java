package com.xlj.rmi;

import com.xlj.rmi.serviceinterfaces.IProducter;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

public class ConfigClient {

    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean()
    {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();

        rmiProxyFactoryBean.setServiceInterface(IProducter.class);
//        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/producter");
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/producter");

        return rmiProxyFactoryBean;
    }

}
