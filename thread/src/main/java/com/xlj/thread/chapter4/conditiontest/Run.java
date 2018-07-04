package com.xlj.thread.chapter4.conditiontest;

public class Run {

    public static void main(String[] args) {

        MyService myService = new MyService();

        for(int i = 0; i  < 10; i++)
        {
            final int j = i;

            Thread threadProduct = new Thread(){
                @Override
                public void run() {
                    for (;;)
                    {
                        myService.set();
                    }
                }
            };

            Thread threadClient = new Thread(){
                @Override
                public void run() {
                    for (;;)
                    {
                        myService.get();
                    }
                }
            };


            threadProduct.setName("productor " + i);
            threadClient.setName("client " + i);

            threadClient.start();
            threadProduct.start();
        }
    }
}
