package com.xlj.model;

public abstract class GetUserTest {

    public GetUserTest(String test, int testN) {
        this.test = test;
        this.testN = testN;
    }

    private GetUserTest(int testN) {
        this.testN = testN;
    }

    public GetUserTest(String test) {
        this.test = test;
    }

    private String test;
    private int testN;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getTestN() {
        return testN;
    }

    public void setTestN(int testN) {
        this.testN = testN;
    }

    public void showMe()
    {
        System.out.println("i am getusertest.");
    }

    public abstract User getBean();

    public User getUser()
    {
        return new User();
    }

}
