package com.xlj.model;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class OrderBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
//        return super.getBeanClass(element);

        return Order.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
//        super.doParse(element, builder);
        String id = element.getAttribute("id");
        String user = element.getAttribute("user");
        String createdate = element.getAttribute("createdate");

        if(StringUtils.hasText(id))
        {
            builder.addPropertyValue("id", id);
        }

        if(StringUtils.hasText(user))
        {
            builder.addPropertyValue("user", user);
        }

        if(StringUtils.hasText(id))
        {
            builder.addPropertyValue("createdate", createdate);
        }
    }
}
