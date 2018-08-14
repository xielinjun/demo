package com.xlj.beanwiringhightLeve.condition;

import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = Config.class)
public class Test implements ApplicationContextAware {

    @Autowired
    MagicBean magicBean;

    @org.junit.Test
    public void magicBeanNotNull()
    {
        System.out.println(this.magicBean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (String str:applicationContext.getEnvironment().getDefaultProfiles()) {
            System.out.println(str);
        }
    }
}
