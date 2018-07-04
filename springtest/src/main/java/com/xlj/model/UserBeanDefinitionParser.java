package com.xlj.model;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
//        return super.getBeanClass(element);

        return User.class;
    }


    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
//        super.doParse(element, builder);

        String username = element.getAttribute("username");
        String password = element.getAttribute("password");

        if(StringUtils.hasText(username))
        {
            builder.addPropertyValue("username", username);
        }

        if(StringUtils.hasText(password))
        {
            builder.addPropertyValue("password", password);
        }
    }
}
