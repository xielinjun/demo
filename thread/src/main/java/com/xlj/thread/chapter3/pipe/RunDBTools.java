package com.xlj.thread.chapter3.pipe;

public class RunDBTools {

    public static void main(String[] args) {
        DBTools dbTools = new DBTools();

        for(int i=0; i < 10; i++)
        {
            new Thread(){
                @Override
                public void run() {
                    dbTools.backupB();
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    dbTools.backupA();
                }
            }.start();
        }
    }

}
