package com.xlj.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.ResolvableType;

public class BeanFactoryTest implements FactoryBean<CmmingXSDTest> {

    public BeanFactoryTest() {
    }

    private BeanFactoryTest(int testN) {
        this.testN = testN;
    }

    private BeanFactoryTest(String test) {
        this.test = test;
    }

    private BeanFactoryTest(int testN, String test) {
        this.testN = testN;
        this.test = test;
    }

    public BeanFactoryTest(int testN, double testD, String test) {
        this.testN = testN;
        this.testD = testD;
        this.test = test;
    }

    private int testN;

    private double testD;

    public int getTestN() {
        return testN;
    }

    public void setTestN(int testN) {
        this.testN = testN;
    }

    public double getTestD() {
        return testD;
    }

    public void setTestD(double testD) {
        this.testD = testD;
    }

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public CmmingXSDTest getObject() throws Exception {
        return new CmmingXSDTest();
    }

    @Override
    public Class<?> getObjectType() {
        return CmmingXSDTest.class;
    }
}
