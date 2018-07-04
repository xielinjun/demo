package com.xlj.thread.chapter7.state;

public class Run extends Thread{

    public Run()
    {
        System.out.println("constructor : " + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("run method : " + Thread.currentThread().getState());
    }

    public static void main(String[] args) {
        Run run = new Run();

        System.out.println("in main 1 : " + run.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        run.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("in main 2 : " + run.getState());
    }

}
