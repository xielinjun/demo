package com.xlj.thread.chapter3.waittonotify;

public class RunAddSubtruct {

    public static void main(String[] args) {

        String lock = new String("");

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadAdd threadAdd = new ThreadAdd(add);
        threadAdd.setName("threadAdd");

        ThreadSubtract threadSubtract = new ThreadSubtract(subtract);
        ThreadSubtract threadSubtract2 = new ThreadSubtract(subtract);

        threadSubtract.setName("threadSubtract");
        threadSubtract2.setName("threadSubtract2");

        threadSubtract.start();
        threadSubtract2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadAdd.start();

    }
}
