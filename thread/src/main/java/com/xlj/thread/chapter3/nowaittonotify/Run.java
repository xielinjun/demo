package com.xlj.thread.chapter3.nowaittonotify;

public class Run {

    public static void main(String[] args) {
        MyList list = new MyList();

        synchronized (list) {
            try {
                list.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();
    }

}