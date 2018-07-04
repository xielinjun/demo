package com.xlj.thread.chapter3.join;

import java.util.Random;

public class Run {

    public static void main(String[] args) {
        for(int i=0; i <1000; i++) {
            System.out.println(Math.random() * 10);
        }

        System.out.println((int)(1 / 1.5));
        System.out.println(1 / 2);
        System.out.println(1 / 3);

    }
}
