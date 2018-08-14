package com.xlj;

import com.xlj.aop.instrumentationjavassits.PerfMonAgent;
import com.xlj.aop.instrumentationjavassits.PerfMonXformer;

import java.lang.instrument.ClassFileTransformer;

/**
 * Hello world!
 *
 */
public class App 
{

    //-javaagent:/home/xielinjun/IdeaProjects/demo/springtest/target/springtest-1.0-SNAPSHOT.jar

    public static void main( String[] args )
    {
        ClassFileTransformer transformer = new PerfMonXformer();
        PerfMonAgent.instrumentation.addTransformer(transformer);

        new App().test();
        new Test().test();
    }

    public void test()
    {
        System.out.println("app.test");
    }
}
