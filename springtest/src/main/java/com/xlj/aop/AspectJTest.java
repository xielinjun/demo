package com.xlj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.testMethod(..))")
    public void test()
    {

    }

    @Before("test()")
    public void beforTest()
    {
        System.out.println("------------------------befor");
    }

    @After("test()")
    public void afterTest()
    {
        System.out.println("------------------------after");
    }

//    @Around("test()")
//    public Object aroundTest(ProceedingJoinPoint p)
//    {
//        System.out.println("------------------------befor around");
//
//        Object o = null;
//
//        try {
//            o = p.proceed();
//
////            System.out.println(p.getArgs().length + (p.getArgs()[0] + " -----------args"));
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        System.out.println("------------------------after around");
//
//        return o;
//    }

}
