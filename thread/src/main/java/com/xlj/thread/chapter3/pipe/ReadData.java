package com.xlj.thread.chapter3.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream input)
    {
        System.out.println("read : ");
        byte[] byteArray = new byte[20];
        try {
            int readLength = input.read(byteArray);
            while (readLength != -1)
            {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }

            System.out.println();
            System.out.println();
            System.out.println();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
