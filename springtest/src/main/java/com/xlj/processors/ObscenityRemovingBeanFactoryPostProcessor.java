package com.xlj.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> obscenities;

    public void setObscenities(Set<String> obscenities) {
        this.obscenities.clear();

        for (String obscenity : obscenities) {
            this.obscenities.add(obscenity);
        }
    }

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obscenities = new HashSet<>();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanNames = beanFactory.getBeanDefinitionNames();

        for (String beanName : beanNames)
        {
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);

            StringValueResolver valueResolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    if(isObsenity(strVal))
                    {
                        return "******";
                    }

                    return strVal;
                }
            };

            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
            visitor.visitBeanDefinition(bd);
        }
    }

    private boolean isObsenity(Object value)
    {
        String potentialObscenity = value.toString();

        return this.obscenities.contains(potentialObscenity);
    }

}
