package com.xlj.aop;

public class TargetBean implements ITargetBean
//public class TargetBean
{

    public String strTest;

    public String getStrTest() {
        return strTest;
    }

    public void setStrTest(String strTest) {
        this.strTest = strTest;
    }

    public void testMethod(String str)
    {
        System.out.println(str);
        System.out.println(this.strTest);
    }
}
