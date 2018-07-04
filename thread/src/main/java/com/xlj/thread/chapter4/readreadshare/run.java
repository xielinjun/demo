package com.xlj.thread.chapter4.readreadshare;

public class run {

    public static void main(String[] args) {

        Service service = new Service();

        for(int i = 0; i < 1; i++)
        {
            new Thread(){
                @Override
                public void run() {
                    service.read();
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    service.write();
                }
            }.start();
        }
    }

}
