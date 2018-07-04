package com.xlj.thread.chapter6.enumsingleton;

public class Run {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++)
        {
            new Thread(){
                @Override
                public void run() {
                    for(int i = 0; i < 5; i++)
                    {
                        System.out.println(MyObject.getInstance().hashCode() );
                    }
                }
            }.start();

        }
    }

}
