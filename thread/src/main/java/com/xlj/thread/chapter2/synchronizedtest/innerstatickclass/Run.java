package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class Run {

    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");

        System.out.println("publicClass = " + publicClass);

        PublicClass.PrivateClass privateClass = new PublicClass.PrivateClass();
        privateClass.setAddress("addressValue");
        privateClass.setAge("ageValue");

        System.out.println("privateValue = " + privateClass);
    }

}
