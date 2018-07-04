package com.xlj.thread.chapter6.serial;

import java.io.*;

public class Run {

    public static void main(String[] args) {

        MyObject myObject = MyObject.getInstance();
        myObject.my = myObject;

        try {
            File file = new File("/home/xielinjun/MyObject.txt");
            if(file.exists())
            {
                file.delete();
            }

            file.createNewFile();



            FileOutputStream fos = new FileOutputStream(file);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myObject);

            oos.close();
            fos.close();

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            MyObject myBack = null;
            try {
                myBack = (MyObject) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ois.close();
            fis.close();

            System.out.println(myObject.getMy());
            System.out.println(myBack.getMy());

            System.out.println(myObject.hashCode() + " " + myBack.hashCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
