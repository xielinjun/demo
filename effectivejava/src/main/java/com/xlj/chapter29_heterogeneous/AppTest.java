package com.xlj.chapter29_heterogeneous;

import com.xlj.App;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class AppTest {

    public static void main(String[] args) {
        AppTest.<String>getObject(String.class);
        AppTest.getAnnotation("com.xlj.App", new AnnotatedElement()
        {
            @Override
            public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
                return null;
            }

            @Override
            public Annotation[] getAnnotations() {
                return new Annotation[0];
            }

            @Override
            public Annotation[] getDeclaredAnnotations() {
                return new Annotation[0];
            }
        });
    }

    public static <T> T getObject(Class<T> type)
    {
        return type.cast(new Object());
    }

    public static Annotation getAnnotation(String annotationTypeClassName, AnnotatedElement target)
    {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return target.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

}
