package com.xlj.rmi;

import com.xlj.rmi.serviceinterfaces.IProducter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class ConfigServer {

    @Bean
    public RmiServiceExporter rmiServiceExporter(@Qualifier("productImpl") IProducter producter)
    {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();

        rmiServiceExporter.setServiceName("producter");
        rmiServiceExporter.setService(producter);
//        rmiServiceExporter.setServicePort(11099);
//        rmiServiceExporter.setRegistryHost("127.0.0.1");
        rmiServiceExporter.setServiceInterface(IProducter.class);

        return rmiServiceExporter;
    }

}
