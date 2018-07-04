package com.xlj.compilerTest;

public class Tester {

    public String str = "Abcd1234";

    public long doubleValue(int i)
    {
        for(int j = 0; j < 100000; j++)
        {

        }

        return i * 2;
    }

    public long calcSum()
    {
        long sum = 0;

        for(int i = 0; i < 100; i++)
        {
            sum += this.doubleValue(i);
        }

        return sum;
    }

}
