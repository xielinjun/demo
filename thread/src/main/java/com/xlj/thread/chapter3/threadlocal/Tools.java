package com.xlj.thread.chapter3.threadlocal;

public class Tools {

    public static ThreadLocal t1 = new ThreadLocal();
    public static ThreadLocal t2 = new ThreadLocal();
    public static InheritableThreadLocal it1 = new InheritableThreadLocal(){

        @Override
        protected Object initialValue() {
            return super.initialValue();
        }

        @Override
        protected Object childValue(Object parentValue) {
            return super.childValue(parentValue);
        }
    };

    static {
        System.out.println(Tools.it1.getClass());
    }
}