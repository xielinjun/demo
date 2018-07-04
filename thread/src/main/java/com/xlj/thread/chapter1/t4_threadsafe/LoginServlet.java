package com.xlj.thread.chapter1.t4_threadsafe;

public class LoginServlet {

    private static String usernameRef;
    private static String passwordRef;

    public synchronized static void doPost(String username, String password)
    {
        try
        {
            LoginServlet.usernameRef = username;

            if(username.equals("a"))
            {
                Thread.sleep(5000);
            }

            LoginServlet.passwordRef = password;
            System.out.println("username: " + LoginServlet.usernameRef
            + "\tpassword: " + LoginServlet.passwordRef);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
