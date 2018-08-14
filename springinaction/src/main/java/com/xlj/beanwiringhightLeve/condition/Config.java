package com.xlj.beanwiringhightLeve.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean()
    {
        return new MagicBean();
    }

}
