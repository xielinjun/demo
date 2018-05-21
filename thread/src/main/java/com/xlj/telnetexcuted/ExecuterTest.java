package com.xlj.telnetexcuted;

import java.io.IOException;

public class ExecuterTest {

    public static void main(String[] args)
    {
        Object obj = System.class;

        Object obj1 = System.out;

        Object obj2 = (HackPrintStream)System.out;

        System.out.println("executer tset.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
