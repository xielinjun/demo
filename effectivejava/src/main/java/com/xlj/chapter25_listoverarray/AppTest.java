package com.xlj.chapter25_listoverarray;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
//        System.out.println(reduce());
    }

    public static void test()
    {
//        Object[] objects = new String[10];
//        objects[0] = 1;

//        List<Object> list = new ArrayList<String>();
    }

    public static <T> void test1()
    {

        System.out.println(new ArrayList<String>().toArray().getClass());

//        Object object;
//
//        object = new T[];
//        object = new ArrayList<GenericTypeTest[]>();
//        object = new ArrayList<GenericTypeTest>();
//        object = new ArrayList<GenericTypeTest>[];
//        object = new GenericTypeTest[];
//        object = new GenericTypeTest<Object>[];
//        object = new GenericTypeTest<T>[];
//        object = new GenericTypeTest<String>[];
//
//        object = new ArrayList<T>()[];
//        object = new ArrayList<String>()[];
//        object = new ArrayList<String>()[];

        new GenericTypeTest<String>().test(new String[]{"1", "2", "3"});
    }

    public static class GenericTypeTest<T>
    {
        public void test(T... args)
        {
//            List<T> list = (List)args;
//            T[] as = (T[])list.toArray();
//            as = (T[]) args;

            for (T t:args) {
                System.out.println(t);
            }
        }

//        public void test(List<T> args)
//        {
//            for (T t:args
//                    ) {
//                System.out.println(t);
//            }
//        }

        public void test(List<?> args)
        {
            for (Object t:args
                    ) {
                System.out.println(t);
            }
        }
    }

    public static int reduce()
    {
        int result = new Function<Integer>(){
            @Override
            public Integer apply(Integer o1, Integer o2) {
                return o1 + o2;
            }
        }.apply(1, 2);

        return result;
    }

//    public static interface Function
//    {
//        Object apply(Object o1, Object o2);
//    }

    public static interface Function<T>
    {
        T apply(T o1, T o2);
    }

}