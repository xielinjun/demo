package com.xlj.aop.instrumentationjavassits;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class PerfMonXformer implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        System.out.println("-----------------------------trasnforming " + className);

        byte[] transformed = null;

        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;

        try {
            cl = pool.makeClass(new ByteArrayInputStream(classfileBuffer));

            if(!cl.isInterface())
            {
                CtBehavior[] methods = cl.getDeclaredBehaviors();
                for (int i = 0; i < methods.length; i++) {
                    if(!methods[i].isEmpty())
                    {
                        try {

                            methods[i].insertAfter("System.out.println(\"leave method " +
                                    methods[i].getLongName() + " run time \");");
                        }
                        catch (Exception ex)
                        {}
                    }
                }
            }

            transformed = cl.toBytecode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }

        return transformed;
    }
}
