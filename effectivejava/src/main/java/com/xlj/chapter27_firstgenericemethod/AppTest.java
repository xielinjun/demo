package com.xlj.chapter27_firstgenericemethod;

import java.util.HashSet;
import java.util.Set;

public class AppTest {

    public static final UnaryFunction<Object> IDENTITY_FUNCTION =
            new UnaryFunction<Object>() {
                @Override
                public Object apply(Object arg) {
                    return arg;
                }
            };

    public static void main(String[] args) {

        String str = AppTest.<String>identityFunction().apply("ss");

        UnaryFunction<String> unaryFunction =
                AppTest.<String>identityFunction();

        String str1 = unaryFunction.apply("dd");

        UnaryFunction unaryFunction1 =
                AppTest.identityFunction();

        String s = (String) unaryFunction1.apply("");
    }

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction()
    {
        return (UnaryFunction<T>) AppTest.IDENTITY_FUNCTION;
    }

    @SuppressWarnings("unchecked")
    public static Set union(Set s1, Set s2)
    {
        Set<?> sr = new HashSet(s1);
        sr.addAll(s2);

        return sr;
    }

    public static <T> Set<T> union1(Set<T> s1, Set<T> s2)
    {
        Set<T> sr = new HashSet<>(s1);
        sr.addAll(s2);

        return sr;
    }

    public static interface UnaryFunction<T>
    {
        T apply(T arg);
    }

    public static interface Comparable<T>
    {
        int comparaTo(T other);
    }

    public static class ComparableImpl<T extends ComparableImpl<T>> implements Comparable<T>
    {

        int value;

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int comparaTo(T other) {

            int nResult = 0;

            if(value > other.value)
            {
                nResult = 1;
            }

            if(value < other.value)
            {
                nResult = -1;
            }

            return nResult;
        }
    }
}
