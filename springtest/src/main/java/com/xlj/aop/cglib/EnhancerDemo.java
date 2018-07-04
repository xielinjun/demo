package com.xlj.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class EnhancerDemo {

    public static void main(String[] args)
    {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodIntercetorImpl());

        EnhancerDemo enhancerDemo = (EnhancerDemo)enhancer.create();

        enhancerDemo.test();
        System.out.println(enhancer);
    }

    public void test()
    {
        System.out.println("EnhancerDemo test()");
    }

    private static class MethodIntercetorImpl implements MethodInterceptor
    {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

            System.out.println("before invoke " + method);

            Object result = methodProxy.invokeSuper(o, objects);

            System.out.println("after invoke " + method);

            return result;
        }
    }
}
