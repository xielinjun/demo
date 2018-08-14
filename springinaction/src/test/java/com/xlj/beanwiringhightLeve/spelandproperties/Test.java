package com.xlj.beanwiringhightLeve.spelandproperties;


import com.xlj.beanwiringhightLeve.spelandproperties.component.BlankDisc;
import com.xlj.beanwiringhightLeve.spelandproperties.component.IBlankDisc;
import com.xlj.beanwiringhightLeve.spelandproperties.config.Config;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
//@ActiveProfiles
public class Test implements ApplicationContextAware {

    @Autowired
    @Qualifier("b1")
    IBlankDisc iblankDisc;

    @Autowired
    Environment environment;

    @org.junit.Test
    public void test()
    {
        if(this.environment != null) {
            for (String str : this.environment.getActiveProfiles()) {
                System.out.println(str);
            }
        }

        System.out.println(this.iblankDisc);

//        System.out.println(((BlankDisc)this.blankDisc).getArtist());
//        System.out.println(((BlankDisc)this.blankDisc).getTitle());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        for (String str:applicationContext.getBeanNamesForType(IBlankDisc.class)) {
            System.out.println(str);
        }
    }
}
