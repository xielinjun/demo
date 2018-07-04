package com.xlj.thread.chapter6.enumsingleton;

import java.sql.Connection;

public class MyObject {

    public static Object getInstance()
    {
        return MyEnumSingleton.connectionFactory.getConnection();
    }

    private enum MyEnumSingleton{
        connectionFactory,
        connectionFactory1,
        connectionFactory2,
        connectionFactory3;

        private Object connection;

            MyEnumSingleton(){
            System.out.println("invoke myobject constructor " + Thread.currentThread().getName() + " " + this);

            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String url = "jdbc:mysql//localhost:1079;database=testDB";
            String username = "sa";
            String password = "Abcd1234";
            String strDiver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

            try {
                Class.forName(strDiver);
            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
            }

            this.connection = new Object();

            System.out.println("end invoke myobject constructor " + Thread.currentThread().getName());
        }

        public Object getConnection()
        {
            return this.connection;
        }
    }


}