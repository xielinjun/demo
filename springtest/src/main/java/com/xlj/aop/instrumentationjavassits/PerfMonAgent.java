package com.xlj.aop.instrumentationjavassits;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class PerfMonAgent {

    public static Instrumentation instrumentation = null;

    public static void premain(String agetnArgs, Instrumentation instrumentation)
    {
        PerfMonAgent.instrumentation = instrumentation;

//        ClassFileTransformer transformer = new PerfMonXformer();
//
//        System.out.println("adding a perfmonxformer instance to the jvm.");
//
//        PerfMonAgent.instrumentation.addTransformer(transformer);
    }

}
