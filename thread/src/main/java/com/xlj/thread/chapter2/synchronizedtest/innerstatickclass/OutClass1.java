package com.xlj.thread.chapter2.synchronizedtest.innerstatickclass;

public class OutClass1 {

    static class InnerClass1
    {
        public void method1(InnerClass2 class2)
        {
            String threadName = Thread.currentThread().getName();

            synchronized (class2)
            {
                System.out.println(threadName + " in InnerClass1 class's method1 method.");

                for (int i = 0; i < 10; i++) {
                    System.out.println("i = " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(threadName + " leave InnerClass1 class's method1 method.");
            }
        }

        public synchronized void method2()
        {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " in InnerClass1 class's method2 method.");

            for (int j = 0; j < 10; j++) {
                System.out.println("j = " + j);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            System.out.println(threadName + " leave InnerClass1 class's method2 method.");
        }

    }

    static class InnerClass2
    {
        public synchronized void method1()
        {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " in InnerClass2 class's method1 method.");

            for (int k = 0; k < 10; k++) {
                System.out.println("k = " + k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(threadName + " leave InnerClass2 class's method1 method.");
        }
    }

}
