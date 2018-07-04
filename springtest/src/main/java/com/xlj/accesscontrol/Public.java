package com.xlj.accesscontrol;

public class Public implements DefaultInterface {

    /**
     * 私有
     */
    private String private__;

    /**
     * 包
     */
    String default__;

    /**
     * 包 子类
     */
    protected String protected__;

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public String test() {
        return "test";
    }
}
