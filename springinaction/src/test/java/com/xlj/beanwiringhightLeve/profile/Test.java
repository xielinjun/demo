package com.xlj.beanwiringhightLeve.profile;

import com.xlj.beanwiringhightLeve.profile.DevelopmentProfileConfig;
import com.xlj.beanwiringhightLeve.profile.MergeProfileConfigs;
import com.xlj.beanwiringhightLeve.profile.ProductionProfileConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
//只有merge 会判断merge 是否含有重复
@ContextConfiguration(
        classes = {
                MergeProfileConfigs.class
                ,ProductionProfileConfig.class
                ,DevelopmentProfileConfig.class
        })
//@ActiveProfiles("dev")
public class Test implements BeanFactoryAware, ApplicationContextAware {

    @Autowired
//    @Qualifier("embeddedDataSource")
    DataSource dataSource;

    @org.junit.Test
    public void dataSourceShouldNotNull()
    {
        System.out.println(this.dataSource);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println(beanFactory.);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (String str: applicationContext.getBeanNamesForType(DataSource.class)) {
            System.out.println(str);
        }
    }
}
