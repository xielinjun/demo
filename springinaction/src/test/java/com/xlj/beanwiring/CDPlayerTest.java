package com.xlj.beanwiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CDPlayerScan.class)
//@ContextConfiguration(classes = CDAndPlayerConfig.class)
//@ContextConfiguration(classes = Configs.class)
//@ContextConfiguration(classes = JavaConfigImportXML.class)
@ContextConfiguration("classpath:beanwiring_importjavaconfig.xml")
public class CDPlayerTest implements ApplicationContextAware, BeanFactoryAware {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void cdShouldNotBeNull() {
        System.out.println(this.cd);
    }

    @Test
    public void setCdPlayerShouldNotBeNull() {
        System.out.println(this.mediaPlayer);
        this.mediaPlayer.play();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println(applicationContext.getBeanNamesForType(CompactDisc.class)[0]);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println(beanFactory);
    }
}
