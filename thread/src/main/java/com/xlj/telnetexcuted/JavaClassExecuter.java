package com.xlj.telnetexcuted;

import java.lang.reflect.Method;

public class JavaClassExecuter {

    public static byte[] init(byte[] classByte)
    {
        HackSystem.clearBuffer();

        ClassModifier cm = new ClassModifier(classByte);

        byte[] modiBytes = null;

        modiBytes = cm.constantPoolUtf8Replace(
                "java/lang/System",
                "com/xlj/telnetexcuted/HackSystem");
//                modiBytes = cm.addConstantPoolUtf8(
//                "com/xlj/telnetexcuted/HackSystem");

//        modiBytes = cm.addConstantPoolClass(
//                "com/xlj/telnetexcuted/HackSystem");

//        modiBytes = cm.fieldClassReplace(
//                "java/lang/System",
//                "com/xlj/telnetexcuted/HackSystem",
//                "out");

//        modiBytes = cm.fieldClassReplace(
//                "java/lang/System",
//                "com/xlj/telnetexcuted/HackSystem",
//                "in");

//        modiBytes = cm.addConstantPoolUtf8(
//                "com/xlj/telnetexcuted/HackPrintStream");

//        modiBytes = cm.addConstantPoolClass(
//                "com/xlj/telnetexcuted/HackPrintStream");

//        modiBytes = cm.methodClassReplace(
//                "java/io/PrintStream",
//                "com/xlj/telnetexcuted/HackPrintStream",
//                "println");

//        modiBytes = cm.constantPoolUtf8Replace(
//                "Ljava/io/PrintStream;",
//                "Lcom/xlj/telnetexcuted/HackPrintStream;");

        return modiBytes;
    }

    public static String execut(byte[] classByte)
    {
        HotSwapClassLoader loader = new HotSwapClassLoader();
//        HotSwapClassLoader loader1 = new HotSwapClassLoader();
//        HotSwapClassLoaderChild loaderChild = new HotSwapClassLoaderChild();
//
//        Class<?> cc = null;
//        try {
//            cc = JavaClassExecuter.class.getClassLoader().loadClass("com.xlj.telnetexcuted.ExecuterTest");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Class<?> cc1 = null;
//        try {
//            cc1 = loader.loadClass("com.xlj.telnetexcuted.ExecuterTest");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Class<?> cc2 = null;
//        try {
//            cc2 = loaderChild.loadClass("com.xlj.telnetexcuted.ExecuterTest");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(cc.getClassLoader() +
//                "--" + cc1.getClassLoader() +
//                "--" + cc2.getClassLoader());
//
//        try {
//            System.out.println(cc.newInstance().equals(cc1.newInstance()));
//            System.out.println(cc.newInstance().equals(cc2.newInstance()));
//            System.out.println(cc1.newInstance().equals(cc2.newInstance()));
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
        Class clazz1 = loader.loadByte(classByte);
//        Class clazz11 = loader1.loadByte(classByte);
//
//        System.out.println(clazz1.getClassLoader() +
//                "-----------------------" + clazz11.getClassLoader());
//
//        Class clazz2 = loaderChild.loadByte(classByte);
//
//        System.out.println(clazz1.getClassLoader() +
//                "--" + clazz2.getClassLoader());

//        try {
//            System.out.println(clazz1.newInstance() == clazz2.newInstance());
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        System.out.println(Thread.currentThread().getContextClassLoader());

        try
        {
            Method method = clazz1.getMethod(
                    "main", String[].class);

            method.invoke(null, new Object[]{ new String[]{ "ddd", "111" }});

         }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return HackSystem.getBufferString();}
}
