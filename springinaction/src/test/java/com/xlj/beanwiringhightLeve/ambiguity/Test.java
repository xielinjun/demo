package com.xlj.beanwiringhightLeve.ambiguity;

import com.xlj.beanwiringhightLeve.ambiguity.componnet.Dessert;
import com.xlj.beanwiringhightLeve.ambiguity.componnet.Hot;
import com.xlj.beanwiringhightLeve.ambiguity.config.Scanner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Scanner.class)
//@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    @Qualifier("cold")
    Dessert dessert;
    @Autowired
    @Qualifier("cold")
    Dessert dessert4;

    @Autowired
    @Hot
    Dessert dessert1;

    @Autowired
    @Hot
    Dessert dessert2;

    @Autowired
    @Hot
    Dessert dessert3;

    @org.junit.Test
    public void testNull()
    {
        System.out.println(this.dessert);
        System.out.println(this.dessert4);

        System.out.println(this.dessert1);
        System.out.println(this.dessert2);
        System.out.println(this.dessert3);
    }

}
