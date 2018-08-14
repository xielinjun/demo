package com.xlj.chapter24_suppresswarnings;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {

    public static void main(String[] args) {
        String[] strs = new String[10];

        System.out.println(toArray(strs).getClass());
        System.out.println(toArray(strs).length);

        for (String str:toArray(strs)) {
            System.out.println(str);
        }

//        new ArrayList().toArray(new Object[]);
    }


    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(T[] a)
    {
        String[] strs = {"1", "2", "3"};
        //unchecked
//        return (T[]) Arrays.copyOf(strs, a.length, a.getClass());

        //unchecked
        return (T[])strs;
    }
}
