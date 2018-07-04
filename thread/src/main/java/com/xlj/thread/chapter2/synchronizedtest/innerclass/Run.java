package com.xlj.thread.chapter2.synchronizedtest.innerclass;

public class Run
{

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println("publicClass = " + publicClass);

        PublicClass.PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println("privateClass = " + privateClass);
    }

}