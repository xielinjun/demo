package com.xlj.classtest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

public class ClassA extends ClassB {
    static{
        System.out.println("ClassA");
    }

    public static String strA = "str";



    private static ClassA inst = null;

    public ClassD classD = new ClassD();

    public ClassD getClassD()
    {
        return this.classD;
    }

    public static ClassA getInst()
    {
        if(inst == null)
        {
            synchronized(ClassA.class) {
                if (inst == null) {
                    ClassA.inst = new ClassA();
                }
            }
        }

        return inst;
    }

    @Override
    public void print(String strParam) {
        this.print1(strParam);
    }

    @Override
    public void print1(String strParam)
    {
        try {
            MethodType mt = MethodType.methodType(void.class,
                    String.class);

            MethodHandle mh = MethodHandles.lookup().
                    findSpecial(
                            ClassB.class,
                            "print1",
                            mt,
                            ClassA.class);

            new Thread(()->{});

//            mh.bindTo(new ClassB());

            try {
                mh.invokeExact(this, strParam);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}