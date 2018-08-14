package com.xlj.jaxws;

import com.xlj.jaxws.webservice.test.ProductWS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@EnableAspectJAutoProxy
public class ConfigClient {

    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean()
    {
        JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean =
                new JaxWsPortProxyFactoryBean();

        try {
            jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(
                    new URL("http://192.168.32.135:12343/services/productws?wsdl"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        jaxWsPortProxyFactoryBean.setPortName("ProductWSPort");
        jaxWsPortProxyFactoryBean.setServiceName("productws");
        jaxWsPortProxyFactoryBean.setNamespaceUri("http://webservice.jaxws.xlj.com/");

        jaxWsPortProxyFactoryBean.setServiceInterface(ProductWS.class);

        return jaxWsPortProxyFactoryBean;
    }

}
