package com.xlj.aop;


import com.xlj.aop.component.IPerformance;
import com.xlj.aop.component.PerformanceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:aop.xml")
public class TestXML {

//    @Autowired
//    PerformanceImpl performanceImpl;

    @Autowired
    IPerformance iPerformance;

    @Test
    public void test()
    {
//        this.performanceImpl.perform("", 0);
//        System.out.println(this.performanceImpl);

        this.iPerformance.perform("", 0);
//        System.out.println(this.iPerformance);
    }

}
