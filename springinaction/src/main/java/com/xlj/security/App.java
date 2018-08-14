package com.xlj.security;

import com.xlj.security.interfaces.IUserDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.security.RolesAllowed;

public class App {

    static AnnotationConfigApplicationContext annotationConfigApplicationContext =
            new AnnotationConfigApplicationContext(Config.class);

    public static void main(String[] args) {
        ((App)annotationConfigApplicationContext.getBean("app")).test();
    }

//    @RolesAllowed({"ROLE_USER"})
    public void test()
    {
        System.out.println(annotationConfigApplicationContext);
        System.out.println(((IUserDao)annotationConfigApplicationContext.getBean("IUserDao")).findAll());
    }

}
