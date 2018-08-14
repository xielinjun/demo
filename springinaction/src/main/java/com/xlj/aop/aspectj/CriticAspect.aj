package com.xlj.aop.aspectj;

public aspect CriticAspect {

    public CriticAspect()
    {

    }

    pointcut performance() :
            execution(* com.xlj.aop.component.IPerformance.perform(..));

    after():performance()
            {
                System.out.println("silencecellphone i am aspectj.");
            }

            //constructor
    pointcut performanceNew() :
            execution(com.xlj.aop.component.PerformanceImpl.new());

    after():performanceNew()
            {
                System.out.println("i am new aspcetj");
            }
}
