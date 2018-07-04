package com.xlj.model;


import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        this.registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
        this.registerBeanDefinitionParser("userxsdtest", new CmmingXSDTestDefinitionParser());
//        this.registerBeanDefinitionParser("order", new OrderBeanDefinitionParser());
    }
}
