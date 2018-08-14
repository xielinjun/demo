package com.xlj.aop;

import com.xlj.aop.component.IEncoreable;
import com.xlj.aop.component.IPerformance;
import com.xlj.aop.component.PerformanceImpl;
import com.xlj.aop.config.Config;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class Test {

    @Autowired
    IPerformance perfromance;

    @Autowired
    IEncoreable encoreableImpl;

    @org.junit.Test
    public void test()
    {
        System.out.println(this.perfromance + " " + this.perfromance.getClass().getSuperclass());
        System.out.println();
        for (Class<?> clazz:this.perfromance.getClass().getInterfaces()) {
            System.out.println(clazz);
        }

        System.out.println();
        for (Method method:this.perfromance.getClass().getMethods()) {

            StringBuilder sb = new StringBuilder();
            sb.append(method.getName() + " (");

            for (Parameter parameter:method.getParameters()) {
                sb.append(parameter.getType() + " " + parameter.getName() + ", ");
            }
            sb.append(")");

            if(method.getName() == "encore")
            {
                try {
                    method.invoke(this.perfromance, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(sb.toString());
        }

        System.out.println();

        this.perfromance.perform("test msg", 10);

        ((IEncoreable)this.perfromance).encore();

        this.encoreableImpl.encore();
    }
}