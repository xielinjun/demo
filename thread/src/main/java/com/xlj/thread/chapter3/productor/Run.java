package com.xlj.thread.chapter3.productor;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        String lock = new String("");

        Productor productor = new Productor(lock);
        Client client = new Client(lock);

        List<Thread> listProductors = new ArrayList();
        List<Thread> listClients = new ArrayList();

        for(int i=0; i < 10; i++)
        {
            Thread threadProductor = new Thread(){
                @Override
                public void run() {
                    while (true)
                    {
                        productor.setValue();
                    }
                }
            };
            threadProductor.setName("productor " + i);
            listProductors.add(threadProductor);

            Thread clientThread = new Thread(){
                @Override
                public void run() {
                    while (true)
                    {
                        client.getVlaue();
                    }
                }
            };
            clientThread.setName("client  " + i);
            listClients.add(clientThread);

            threadProductor.start();
            clientThread.start();
        }

    }

}
