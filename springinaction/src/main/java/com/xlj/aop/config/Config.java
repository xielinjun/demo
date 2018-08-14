package com.xlj.aop.config;

import com.xlj.aop.component.Audience;
import com.xlj.aop.component.EncoreableImpl;
import com.xlj.aop.component.IPerformance;
import com.xlj.aop.component.PerformanceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy()
public class Config {

    @Bean
    public Audience audience()
    {
        return new Audience();
    }

    @Bean
    public PerformanceImpl perfromanceImpl()
    {
        return new PerformanceImpl();
    }

    @Bean
    public EncoreableImpl encoreableImpl()
    {
        return new EncoreableImpl();
    }

}