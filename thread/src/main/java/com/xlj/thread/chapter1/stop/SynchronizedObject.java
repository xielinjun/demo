package com.xlj.thread.chapter1.stop;

public class SynchronizedObject {

    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public synchronized void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(1000 * 100);
            this.password = password;
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
