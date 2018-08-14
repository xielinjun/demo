package com.xlj.aop.component;

public class PerformanceImpl implements IPerformance {

    public PerformanceImpl() {
    }

    @Override
    public void perform(String msg, int count) {
        System.out.println("i am performed.");
    }
}
