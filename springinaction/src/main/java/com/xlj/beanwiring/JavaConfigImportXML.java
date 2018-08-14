package com.xlj.beanwiring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:beanwiring.xml"})
public class JavaConfigImportXML {

    @Qualifier
    @Bean("CDPlayer")
    public MediaPlayer getCDPlayer(CompactDisc cd)
    {
        return new CDPlayer(cd);
    }

}
