package com.xlj;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import java.util.ArrayList;

@Configuration
@ComponentScan(basePackages = {"com.xlj.web.controllers"})
@EnableWebMvc
public class DispatcherServletConfig {


    @Bean
    public ViewResolver BeanNameViewResolver()
    {
        return new BeanNameViewResolver();
    }

    @Bean
    public View xmlViews()
    {
        return new MappingJackson2XmlView();
    }

    @Bean
    public View jasonViews()
    {
        return new MappingJackson2JsonView();
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver()
    {
        ContentNegotiatingViewResolver contentNegotiatingViewResolver =
                new ContentNegotiatingViewResolver();

        java.util.List<View> listViews = new ArrayList<>();

        listViews.add(this.xmlViews());
        listViews.add(this.jasonViews());

        contentNegotiatingViewResolver.setDefaultViews(listViews);

//        contentNegotiatingViewResolver.setOrder(9998);

        return contentNegotiatingViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer()
    {
        FreeMarkerConfigurer freeMarkerConfigurer =
                new FreeMarkerConfigurer();

        freeMarkerConfigurer.setTemplateLoaderPath("/");

        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver freeMarkerViewResolver()
    {
        FreeMarkerViewResolver freeMarkerViewResolver =
                new FreeMarkerViewResolver();

        freeMarkerViewResolver.setPrefix("/WEB-INF/views/");
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setContentType("text/html; charset=UTF-8");
//        freeMarkerViewResolver.setOrder(9999);

        return freeMarkerViewResolver;
    }

    @Bean
    public ViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver =
                new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
//        internalResourceViewResolver.setOrder(10000);

        return internalResourceViewResolver;
    }

}
