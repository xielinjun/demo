package com.xlj.thread.chapter7.multiexception;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Run {

    public static void main(String[] args) {

//        MyThread myThread = new MyThread();
//        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
//        myThread.start();

//        MyThread myThread = new MyThread();
//        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
//        myThread.start();

//        MyThreadGorup myThreadGorup = new MyThreadGorup("my thread group");
//        MyThread myThread = new MyThread(myThreadGorup, "my thread");
//        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
//        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
//        myThread.start();

//        MyThreadGorup myThreadGorup = new MyThreadGorup("my thread group");
//        MyThread myThread = new MyThread(myThreadGorup, "my thread");
//        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
//        myThread.start();

//        MyThreadGorup myThreadGorup = new MyThreadGorup("my thread group");
//        MyThread myThread = new MyThread(myThreadGorup, "my thread");
//        myThread.start();

        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(
                new ClassPathResource("my.xml"));

        MyThread object = (MyThread)xmlBeanFactory.getBean("myThread");

        object.start();
    }
}
