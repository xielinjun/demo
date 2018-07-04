package com.xlj.thread.chapter3.productorstack;

public class Run {

    public static void main(String[] args) {
        Object lock = new Object();

        {
            final int j = 0;
            new Thread() {
                @Override
                public void run() {
                    Client client = new Client(lock);
                    Thread.currentThread().setName("consume " + j);
                    while (true) {
                        client.consume();
                    }
                }
            }.start();
        }

        for(int i = 0; i < 10; i++)
        {
            final int k = i;
            new Thread(){
                @Override
                public void run() {
                    Productor productor = new Productor(lock);
                    Thread.currentThread().setName("product " + k);
                    while (true)
                    {
                        productor.product();
                    }
                }
            }.start();

//            new Thread(){
//                @Override
//                public void run() {
//                    Client client = new Client(lock);
//                    Thread.currentThread().setName("consume " + k);
//                    while (true)
//                    {
//                        client.consume();
//                    }
//                }
//            }.start();
        }

    }

}
