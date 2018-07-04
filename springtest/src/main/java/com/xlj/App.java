package com.xlj;

import com.xlj.accesscontrol.Public;
import com.xlj.aop.ITargetBean;
import com.xlj.aop.TargetBean;
import com.xlj.aop.jdkproxy.MyInvocationHandler;
import com.xlj.aop.jdkproxy.UserService;
import com.xlj.aop.jdkproxy.UserServiceImpl;
import com.xlj.converters.String2DateConverter;
import com.xlj.events.TestEvent;
import com.xlj.model.GetUserTest;
import com.xlj.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


//        float cost = 150;
//        for(int i = 1; i < 61; i++)
//        {
//            cost = cost * 1.039F + 10;
//            System.out.println(i + " " + cost);
//        }

//        java.util.List<?> l = new ArrayList<>();
//        java.util.List l1 = new ArrayList();
//
//        Class<?> cla = Class.class;
//        Class<Class> cla1 = Class.class;
//        Class cla2 = Class.class;
//
//        System.out.println(cla == cla1);
//        System.out.println(cla == cla2);
//
//        l.add(null);


//        MyClassPathXmlApplicationContext myClassPathXmlApplicationContext = new MyClassPathXmlApplicationContext("my.xml");
//        (Def)new Public()

//        UserService userServiceTarget = new UserServiceImpl();
//
//        UserService userService = (UserService)Proxy.newProxyInstance(
//                App.class.getClassLoader(),
//                userServiceTarget.getClass().getInterfaces(),
//                new MyInvocationHandler(userServiceTarget));
//
//        userService.add();

        System.setProperty("-Dspring.profiles.active", "dev");

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("my.xml");

        System.out.println();
        System.out.println("aop------------------------------");

        ((TargetBean)classPathXmlApplicationContext.getBean("aopTargetBean")).testMethod("teststsetsetsetsetestset");

        System.out.println();
        System.out.println("event------------------------------");

        TestEvent testEvent = new TestEvent("hello", "event test msg");
        classPathXmlApplicationContext.publishEvent(testEvent);

        System.out.println();
        System.out.println("i18n 1------------------------------");

        String pattern1 = "{0}, 你好, 你在 {1} 在中国工商银行存入 {2} 元.";
        String pattern2 = "at {1,time,short} on{1,date,long}, {0} paid {2,number,currecy}.";

        Object[] params = {"john", new GregorianCalendar().getTime(), 1.0E3};

        String msg1 = MessageFormat.format(pattern1, params);

        MessageFormat mf = new MessageFormat(pattern2, Locale.US);

        String msg2 = mf.format(params);

        System.out.println(msg1);
        System.out.println(msg2);

        System.out.println();
        System.out.println("i18n 2------------------------------");

        Object[] params2 = {"john",  new GregorianCalendar().getTime()};
        System.out.println(classPathXmlApplicationContext.getMessage("test", params2, Locale.US));
        System.out.println(classPathXmlApplicationContext.getMessage("test", params2, Locale.CHINA));

        System.out.println();
        System.out.println();

//        BeanFactoryPostProcessor beanPostProcessor =
//                (BeanFactoryPostProcessor)classPathXmlApplicationContext.getBean("obscenityRemovingBeanFactoryPostProcessor");
//        beanPostProcessor.postProcessBeanFactory(classPathXmlApplicationContext.getBeanFactory());

//        System.out.println(classPathXmlApplicationContext.getBean("customEditorConfigurer"));

        System.out.println(classPathXmlApplicationContext.getBean("user_Replaced_PostPorcessor"));
        System.out.println(classPathXmlApplicationContext.getBean("user_Replaced_Properties"));
        System.out.println(classPathXmlApplicationContext.getBean("user2"));
        System.out.println(classPathXmlApplicationContext.getBean("user_Replaced"));

//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("my.xml"));
//
//        System.out.println(beanFactory.getBean("getUserTest_Lookup"));
//
//        System.out.println(beanFactory.getBean("beanFactoryTest"));
//        System.out.println(beanFactory.getBean("beanFactoryTest"));
//        System.out.println(beanFactory.getBean("&beanFactoryTest"));
//
//        System.out.println(beanFactory.getBean("circleA"));
//        System.out.println(beanFactory.getBean("circleA"));
//
//        System.out.println(beanFactory.getBean("user2"));
//
//        System.out.println(beanFactory.getBean("testUserXSDTest"));
//
//        System.out.println(beanFactory.getBean("user2").hashCode());
//        System.out.println(beanFactory.getBean("user3").hashCode());
//        System.out.println(beanFactory.getBean("user6").hashCode());
//        System.out.println(beanFactory.getBean("user10").hashCode());
//
//        System.out.println(beanFactory.getBean("user10") == beanFactory.getBean("user6"));
//        System.out.println(beanFactory.getBean("user10") == beanFactory.getBean("user2"));
////        System.out.println(beanFactory.getBean("user10") == beanFactory.getBean("user"));
//
//        System.out.println(beanFactory.getBean("user_Replaced"));
//        ((User)beanFactory.getBean("user_Replaced")).changeMe();
//        System.out.println(beanFactory.getBean("testUser"));
//        ((User)beanFactory.getBean("testUser")).changeMe();
//
//        System.out.println();
//
//        System.out.println(((GetUserTest)beanFactory.getBean("getUserTest")).getBean());
//        ((GetUserTest)beanFactory.getBean("getUserTest")).showMe();
//        ((GetUserTest)beanFactory.getBean("getUserTest")).getBean().showMe();
//        ((GetUserTest)beanFactory.getBean("getUserTest")).getUser().showMe();

//        System.out.println(beanFactory.getBean("testOrder"));

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("my.xml");
//        System.out.println(beanFactory.getBean("user"));


    }
}