package com.xlj.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyInstantiationAwareBeanProcessor befor: " + bean + " " + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyInstantiationAwareBeanProcessor after: " + bean + " " + beanName);
        return null;
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
}
