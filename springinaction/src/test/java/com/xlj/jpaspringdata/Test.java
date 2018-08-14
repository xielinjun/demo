package com.xlj.jpaspringdata;

import com.xlj.jpaspringdata.daointerfaces.IUserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test implements ApplicationContextAware, BeanFactoryAware, BeanFactoryPostProcessor {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

//        for (String beanName:applicationContext.getBeanDefinitionNames()) {
//            System.out.println(beanName + " " +
//                    ((ConfigurableListableBeanFactory)applicationContext).getMergedBeanDefinition(beanName));
//        }

    }

    @Autowired
    IUserDao userDao;

    @org.junit.Test
    public void tset()
    {
        System.out.println(this.userDao);

        System.out.println(this.userDao.findAll());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);

        DefaultListableBeanFactory defaultListableBeanFactory =
                (DefaultListableBeanFactory)beanFactory;

        for (String beanName:defaultListableBeanFactory.getBeanDefinitionNames())
        {
            System.out.println(beanName + "---------------" +
            defaultListableBeanFactory.getBeanDefinition(beanName));
            System.out.println();
            System.out.println();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
