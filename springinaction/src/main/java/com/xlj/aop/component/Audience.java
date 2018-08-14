package com.xlj.aop.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class Audience {

    //weaving-------------------------------------------------------------------------------------------
    Map<String, Integer> methodInvokeCount = new HashMap<>();
    Map<String, java.util.List<Object>> methodArgs = new HashMap<>();

    @Pointcut("execution(* com.xlj.aop.component.IPerformance.perform(String, int)) && args(msg, count)")
    public void pointCut(String msg, int count)
    {

    }

    @Pointcut("execution(* com.xlj.aop.component.IPerformance.perform(String, int))")
    public void pointCutAround()
    {

    }

    @Before("pointCut(msg, count)")
    public void silenceCellPhone(String msg, int count)
    {
        System.out.println("silenceCellPhone silengcing cell phones.");
    }

    @Before("pointCut(msg, count)")
    public void takeSeats(String msg, int count)
    {
        System.out.println("takeSeats taking seats." + msg + count);
    }

    @AfterReturning("pointCut(msg, count)")
    public void applause(String msg, int count)
    {
        System.out.println("applause clap clap clap." + msg + count);
    }

    @AfterThrowing("pointCut(msg, count)")
    public void demandRefund(String msg, int count)
    {
        System.out.println("demandRefund demanding a refund." + msg + count);
    }

    @Around("pointCutAround()")
    public Object watchPerform(ProceedingJoinPoint proceedingJoinPoint)
    {
        System.out.println("watchPerform befor silenceCellPhone and takeSeats.");
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("watchPerform after o no i want demand refund.");

        return result;
    }

    //intorducer---------------------------------------------------------------------------

    @DeclareParents(value = "com.xlj.aop.component.IPerformance+",
            defaultImpl = com.xlj.aop.component.EncoreableImpl.class)
    public IEncoreable encoreable;

    @Pointcut("execution(* com.xlj.aop.component.IEncoreable.encore(..))")
    public void pointCutEncoreableAround()
    {

    }

    @Around("pointCutEncoreableAround()")
    public Object watchEncore(ProceedingJoinPoint proceedingJoinPoint)
    {
        System.out.println("watchEncore befor silenceCellPhone and takeSeats.");
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("watchEncore after o no i want demand refund.");

        return result;
    }
}
