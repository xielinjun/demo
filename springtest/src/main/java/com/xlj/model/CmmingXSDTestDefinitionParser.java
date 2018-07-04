package com.xlj.model;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class CmmingXSDTestDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {

        return CmmingXSDTest.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
//        super.doParse(element, builder);

        String id = element.getAttribute("id");
        String username = element.getAttribute("username");
        String password = element.getAttribute("password");

        if(StringUtils.hasText(id))
        {
            builder.addPropertyValue("id", id);
        }

        if(StringUtils.hasText(id))
        {
            builder.addPropertyValue("username", username);
        }

        if(StringUtils.hasText(id))
        {
            builder.addPropertyValue("password", password);
        }

    }
}
