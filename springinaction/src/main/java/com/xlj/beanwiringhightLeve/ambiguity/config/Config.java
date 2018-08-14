package com.xlj.beanwiringhightLeve.ambiguity.config;

import com.xlj.beanwiringhightLeve.ambiguity.componnet.Cake;
import com.xlj.beanwiringhightLeve.ambiguity.componnet.Cookies;
import com.xlj.beanwiringhightLeve.ambiguity.componnet.Dessert;
import com.xlj.beanwiringhightLeve.ambiguity.componnet.IceCream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean
    public Dessert cake()
    {
        return  new Cake();
    }

    @Bean
    public Dessert iceCream()
    {
        return  new IceCream();
    }

    @Bean
    public Dessert cookies()
    {
        return  new Cookies();
    }
}
