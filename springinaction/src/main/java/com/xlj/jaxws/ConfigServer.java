package com.xlj.jaxws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class ConfigServer {

    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter()
    {
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter =
                new SimpleJaxWsServiceExporter();

        simpleJaxWsServiceExporter.setBaseAddress("http://192.168.32.135:12343/services/");

        return simpleJaxWsServiceExporter;
    }

}
