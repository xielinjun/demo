package com.xlj.beanwiringhightLeve.spelandproperties.config;

import com.xlj.beanwiringhightLeve.spelandproperties.component.BlankDisc;
import com.xlj.beanwiringhightLeve.spelandproperties.component.BlankDisc2;
import com.xlj.beanwiringhightLeve.spelandproperties.component.IBlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("META-INF/properties/speladnproperties.properties")
public class Config {

    @Autowired
    Environment environment;

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyResourceConfigurer()
    {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer =
                new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocation(
                new ClassPathResource("META-INF/properties/speladnproperties.properties")
        );

        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public IBlankDisc blankDisc1(
            @Value("${string1}") String string1,
            @Value("${string2}") String string2)
    {
        return new BlankDisc(
                string1,
                string2);
    }

    @Bean
    @Qualifier("b1")
    public IBlankDisc blankDisc4(
            @Value("#{systemProperties['java.version']}") String string1,
            @Value("#{blankDisc1.title}") String string2)
    {
        return new BlankDisc(
                string1,
                string2);
    }

    @Bean
    public IBlankDisc blankDisc2() {

        return new BlankDisc2();

    }

    @Bean
    public IBlankDisc blankDisc() {
        if(this.environment == null)
        {
            return new BlankDisc2();
        }

        return new BlankDisc(
                this.environment.getProperty("string2") + 2,
                this.environment.getProperty("string3") + 2);

    }

}