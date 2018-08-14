package com.xlj.chapter23_genericetype;

import com.xlj.App;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AppTest {

    public static void main(String[] args) {

//        List<Object> list = new ArrayList<>();
//        List<String> listString = new ArrayList<>();
//        List<Integer> listInteger = new ArrayList<>();
//
//        list.add(111);
//        listString = list;
//        listString.add("String");
//
//        for (int i=0; i < listString.size(); i++)
//        {
//            System.out.println(listString.get(i));
//        }

//        for (String str:listString) {
//            System.out.println(str);
//        }

//        GetObject getObject = new GetObject();
//        GetObject<Integer> getObject1 = new GetObject<Integer>();
//        GetObject<String> getObject2 = new GetObject<String>();
//
//        getObject.setObject("String");
//        getObject1 = getObject;
//        getObject1.setObject(100);
//
//        System.out.println(getObject.getObject());
//        System.out.println(getObject1.getObject());
//        System.out.println(getObject2.getObject());

//        getObject = getObject1;
//        getObject = getObject2;
//        getObject1 = getObject2;

//        for (Method method:int.class.getMethods()
//                ) {
//            System.out.println(method.getName());
//        }
//
//        try {
//            System.out.println(int.class.newInstance());
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        tsetGenerice1();

    }

    public static int getEquals(Set<?> s1, Set<?> s2)
    {
        int nResult = 0;

        for (Object obj:s1) {
            if(s2.contains(obj))
            {
                nResult++;
            }
        }

        return nResult;
    }

    public static void tsetGenerice()
    {
        List<?> list = new ArrayList<String>();
        List<String> list1String = new ArrayList<>();

//        list = list1String;
//        list.add("");

        GetObject<?> getObject = null;
//        getObject.setObject("");
    }

    public static void tsetGenerice1()
    {
        System.out.println(List.class);
        System.out.println(List[].class);
        System.out.println(String.class);
        System.out.println(String[].class);
        System.out.println(Integer.class);
        System.out.println(Integer[].class);
        System.out.println(int.class);
        System.out.println(int[].class);
        System.out.println(GetObject.class);
        System.out.println(GetObject[].class);

//        System.out.println(GetObject<?>.class);
//        System.out.println(GetObject<String>.class);
//        System.out.println(GetObject<Integer>.class);
//        System.out.println(List<?>);
//        System.out.println(List<String>);
//        System.out.println(List<Integer>);
//                System.out.println(List<Object.class>.);
    }

    public static void tsetGenerice2(Object o)
    {
        System.out.println(o instanceof Set);
        System.out.println(o instanceof Set<?>);

//        System.out.println(o instanceof Set<Object>);
//        System.out.println(o instanceof Set<String>);
//        System.out.println(o instanceof Set<Integer>);
    }

}
