package com.xlj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String strConfigs)
    {
        super(strConfigs);
    }

    @Override
    protected void initPropertySources() {
        super.initPropertySources();

        this.getEnvironment().setRequiredProperties("A", "B");
    }
}
