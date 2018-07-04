package com.xlj;

import com.xlj.classtest.ClassA;
import com.xlj.classtest.ClassB;
import com.xlj.classtest.ClassD;
import com.xlj.compilerTest.Tester;
import com.xlj.telnetexcuted.JavaClassExecuter;
import com.xlj.thread.CallableFutur;
import com.xlj.thread.RunnableThread;
import com.xlj.thread.ThreadThread;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.misc.Unsafe;

import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class App
{

//    static byte[] sbs1 = new byte[1024 * 512];
//    static byte[] sbs2 = new byte[1024 * 512];
//    static byte[] sbs3 = new byte[1024 * 512];
//    static byte[] sbs4 = new byte[1024 * 512];
//    static byte[] sbs5 = new byte[1024 * 512];
//    static byte[] sbs6 = new byte[1024 * 512];
//    static byte[] sbs7 = new byte[1024 * 512];
//    static byte[] sbs8 = new byte[1024 * 512];
//    static byte[] sbs9 = new byte[1024 * 512];
//    static byte[] sbs10 = new byte[1024 * 512];
//    static byte[] sbs11 = new byte[1024 * 512];
//    static byte[] sbs12 = new byte[1024 * 512];
//    static byte[] sbs13 = new byte[1024 * 512];
//    static byte[] sbs14 = new byte[1024 * 512];
//    static byte[] sbs15 = new byte[1024 * 1024 * 100];

    static int stackCount = 0;

    static App app = new App();

    int noVolatelTest = 0;
    volatile int volatileTest = 0;

//    @SuppressWarnings("unused")
    public static void main( String[] args ) {
//        callabelFutur();
//        volatialTest();
//        runnableThread();
//        threadThread();
//        threadPoolSequence();
//        synchronizedTest();
//        interruptTest();
//        interruptTest2();
//        waitObjTest();
//        waitObjectNotifyallTest();


//        //栈溢出 -Xss512K
//        stackCount++;
//        System.out.println(stackCount);
//        main(args);

//        //堆溢出 -Xms20M -Xmx20M -Xmn10M
//        List<App> listTread = new ArrayList<>();
//        for(;;)
//        {
//            listTread.add(new App());
//        }

//        //内存溢出(堆溢出)
//        for(;;)
//        {
//            Thread thread = new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//
//                            for (;;)
//                            {}
//                        }
//                    }
//            );
//
//            thread.start();
//
//            System.out.println(stackCount++);
//        }

//        //运行时常量池溢出
//        List<String> list = new ArrayList<>();
//        for(;;)
//        {
//            list.add((stackCount++ + "").intern());
//        }

//        //字符串比较,jdk1.7 常量池只记录首次出现常量的引用
//        //如果后续的字符串的引用等于常量池记录的首次出现常量的引用结果为真,其他false
//        String sEmpt1 = "";
//        String sEmpt2 = "";
//        String sEmpt3 = sEmpt1;
//        System.out.println(sEmpt1 == "");
//        System.out.println(sEmpt2 == "");
//        System.out.println(sEmpt3 == "");
//        System.out.println(sEmpt1 == sEmpt2);
//        System.out.println(sEmpt3 == sEmpt2);
//
//        String sEmpt = new String("");
//        System.out.println(sEmpt == "");
//        System.out.println(sEmpt.intern() == "");
//
//        String s = new String("计算机");
//        String s1 = new String("计算机");
//        System.out.println(s == s1);
//        System.out.println("计算机" == s1.intern());
//
//        String str = new StringBuilder()
//                .append("计算机")
//                .append("软件")
//                .toString();
//        System.out.println(str == str.intern());
//        System.out.println("计算机软件" == str.intern());
//        System.out.println("计算机软件" == str);
////        System.out.println(s == str);
////        System.out.println(s == str.intern());
//        System.out.println("---------------------");
//
//        String str1 = new StringBuilder()
//                .append("ja")
//                .append("va")
//                .toString();
//        System.out.println(str1 == str1.intern());
//        System.out.println("java" == str1.intern());
//        System.out.println("java" == str1);
//        System.out.println("---------------------");
//
//        String str2 = new StringBuilder()
//                .append("vo")
//                .append("id")
//                .toString();
//        System.out.println(str2 == str2.intern());
//        System.out.println("void" == str2.intern());
//        System.out.println("void" == str2);
//        System.out.println("---------------------");
//
//        String str3 = new StringBuilder()
//                .append("ni")
//                .append("hao")
//                .toString();
//        System.out.println(str3 == str3.intern());
//        System.out.println("nihao" == str3.intern());
//        System.out.println("nihao" == str3);
//        System.out.println("---------------------");

//        //方法区类溢出(类信息 太多)
//        for(;;)
//        {
//            Enhancer enhancer =
//                    new Enhancer();
//            enhancer.setSuperclass(App.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(
//                    new MethodInterceptor() {
//                        @Override
//                        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                            return methodProxy.invokeSuper(o, objects);
//                        }
//                    }
//            );
//
//            System.out.println(enhancer.create());
//        }

//        //直接内存溢出 -XX:MaxDirectMemorySize=10M
//        Field field = Unsafe.class.getDeclaredFields()[0];
//        field.setAccessible(true);
//        Unsafe unsafe = null;
//        try {
//            unsafe = (Unsafe)field.get(null);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        for (;;)
//        {
//            unsafe.allocateMemory(1024 * 1024);
//        }


//        //垃圾回收调用 finalize
//        //App.app = new App();
//
//        App.app = null;7exexxxl
//        System.gc();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        if(App.app == null)
//        {
//            System.out.println("null");
//        }
//        else
//        {
//            System.out.println("not null");
//        }
//
//        App.app = null;
//        System.gc();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        if(App.app == null)
//        {
//            System.out.println("null");
//        }
//        else
//        {
//            System.out.println("not null");
//        }

//        //内存分配测试
//        byte[] allocation1;
//        byte[] allocation2;
//        byte[] allocation3;
//        byte[] allocation4;
//
//        allocation1 = new byte[1024 * 1024 * 2];
//        allocation2 = new byte[1024 * 1024 * 2];
//        allocation3 = new byte[1024 * 1024 * 5];
//        allocation4 = new byte[1024 * 1024 * 5];

//        //对象 -XX:PretenureSizeThreshold=3145728 大对象直接进入老年带
//                -XX:PretenureSizeThreshold=3145728
//        byte[] allocation;
//        allocation = new byte[1024 * 1024 * 4];

//        //长期存活的对象进入老年带
//        -verbose:gc
//                -XX:+PrintGCDetails
//                -Xms20M
//                -Xmx20M
//                -Xmn10M
//                -Xss10M
//                -XX:SurvivorRatio=8
//                -XX:PermSize=10M
//                -XX:MaxPermSize=10M
//                -XX:MaxDirectMemorySize=10M
//                -XX:MaxTenuringThreshold=1

//        byte[] allocation1;
//        byte[] allocation2;
//        byte[] allocation3;
//        byte[] allocation4;
//        byte[] allocation5;
//        byte[] allocation6;
//        byte[] allocation7;
//        byte[] allocation8;
//        byte[] allocation9;
//        byte[] allocation10;
//        byte[] allocation11;
//        byte[] allocation12;
//        byte[] allocation13;
//
//        allocation1 = new byte[(1024 * 1024) / 4];
//        allocation2 = new byte[(1024 * 1024) * 4];
//        allocation3 = new byte[(1024 * 1024) * 4];
//        allocation4 = new byte[(1024 * 1024) / 4];
//        allocation5 = new byte[(1024 * 1024) / 4];
//        allocation6 = new byte[(1024 * 1024) / 4];
//        allocation7 = new byte[(1024 * 1024) / 4];
//        allocation8 = new byte[(1024 * 1024) / 4];
//        allocation9 = new byte[(1024 * 1024) / 4];
//        allocation10 = new byte[(1024 * 1024) / 4];
//        allocation11 = new byte[(1024 * 1024) / 4];
//        allocation12 = new byte[(1024 * 1024) / 4];
//        allocation13 = new byte[(1024 * 1024) / 4];

//
//        String str1 = "dfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
//        String str = new String("dfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
////        String str2 = "dfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
////        String str3 = "dfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssdfadfasdfasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
//        System.out.println(str1 == str.intern());
////        System.out.println(str1 == str.intern());
//        System.out.println(str2 == str.intern());
//        System.out.println(str3 == str.intern());


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (App.class) {
//                    for (; ; ) {
//                        Object obj = new Object();
//
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }).start();
//
//        synchronized (App.class) {
//            for (int i = 0; i < 10 ; i++) {
//                Object obj = new Object();
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        ClassA classA = new ClassA();

//        ClassD classD;
//        String strD = ClassD.strD1;
//        System.out.println(ClassA.strA == ClassD.strD);

//
//        List<Thread> threads = new ArrayList<>();
//        for(int i = 0; i < 100; i++)
//        {
//            threads.add(new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(ClassA.getInst().getClassD().strDD);
//                }
//            }));
//        }
//
//        for(int i = 0; i < 100; i++)
//        {
//            threads.get(i).start();
//        }
//
//        new ClassA().print("mhhhhhhhhhhhhhhhhhhhhhhhhhhh");


        try {
            InputStream is = new FileInputStream(
                    "/home/xielinjun/IdeaProjects/" +
                            "demo/thread/target/" +
                    "classes/com/xlj/telnetexcuted/" +
                            "ExecuterTest.class");

            byte[] b = new byte[is.available()];
            is.read(b);
            is.close();

            byte[] bModify;

            try {
                bModify = JavaClassExecuter.init(b);

                OutputStream os = new FileOutputStream(
                        "/home/xielinjun/IdeaProjects/" +
                                "demo/thread/target/" +
                                "classes/com/xlj/telnetexcuted/" +
                                "ExecuterTest_modify.class");
                os.write(bModify);
                os.close();

                System.out.println("main: " + JavaClassExecuter.execut(bModify));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            System.gc();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        Long g1 = 3L;
//        Long h = 642L;
//        Long j = 127L;
//        Long j1 = 127L;
//        Float k = 1F;
//        Float k1 = 1F;
//        Float l = 1F;
//        Float l1 = 1F;
//
//        String integerCacheHighPropValue =
//                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
//
//        System.out.println("c == d " + (c == d));
//        System.out.println("e == f " + (e == f));
//        System.out.println("c == (a + b) " +  (c == (a + b)));
//        System.out.println("c.equals(a + b) " +  c.equals(a + b));
//        System.out.println("g == g1 " +  (g == g1));
//        System.out.println("j == j1 " +  (j == j1));
//        System.out.println("g == (a + b) " +  (g == (a + b)));
//        System.out.println("h == (f + e) " +  (h == (f + e)));
//        System.out.println("g.equals(a + b) " +  g.equals(a + b));
//        System.out.println("k == k1 " +  (k == k1));


////        long value = new Tester().calcSum();
//
//        String strtest2 = new StringBuilder().append("Abcd").append("1234").toString();
//        String strtest1 = "Abcd" + "1234";
//        String strtest = "Abcd1234";
//
//        System.out.println(strtest == strtest2);
//        System.out.println(strtest == strtest1);
//        System.out.println(strtest1 == strtest2);
//
//        System.out.println(strtest == new Tester().str);
//
//        System.out.println(strtest == String.valueOf(strtest));
//
//        System.out.println(strtest == String.valueOf("Abcd1234"));
//
//        System.out.println(strtest == new String(strtest).intern());
//
//        Integer a = 10;

        System.gc();

        System.out.println("111111111111111111111111111111111111111-------------------------------");

        byte[] b4 = null;
        b4 = new byte[1024 * 512];
        System.out.println("1-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("2-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("3-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("4-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("5-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("6-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("7-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("8-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("9-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("10-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("11-------------------------------");
        b4 = new byte[1024 * 512];
        System.out.println("12-------------------------------");
        b4 = new byte[1024 * 700];
        System.out.println("13-------------------------------");
        b4 = new byte[1024 * 300];
        b4 = new byte[1024 * 300];
        b4 = new byte[1024 * 150];
        byte[] b9 = new byte[1024 * 150];

        System.out.println("111111111111111111111111111111111111111-------------------------------");


        System.out.println("22222222222222222222222222222222222222-------------------------------");

        byte[] b8 = null;
        b8 = new byte[1024 * 512];
        System.out.println("1-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("2-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("3-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("4-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("5-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("6-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("7-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("8-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("9-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("10-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("11-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("12-------------------------------");
        b8 = new byte[1024 * 512];
        System.out.println("13-------------------------------");
        b8 = new byte[1024 * 100];
        byte[] b10 = new byte[1024 * 500];
        b10 = null;

        System.out.println("22222222222222222222222222222222222222-------------------------------");


        System.out.println("3333333333333333333333333333333333333333333-------------------------------");

        byte[] b18 = null;
        b18 = new byte[1024 * 512];
        System.out.println("1-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("2-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("3-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("4-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("5-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("6-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("7-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("8-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("9-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("10-------------------------------");
        b18 = new byte[1024 * 512];
        System.out.println("13-------------------------------");


        b18 = new byte[1024 * 50];
        System.out.println("14-------------------------------");
        byte[] b18___ = new byte[1024 * 850];
        byte[] b18____ = new byte[1024 * 200];
        System.out.println("15-------------------------------");
//        byte[] b18_ = new byte[1024 * 100];
        System.out.println("155-------------------------------");
        byte[] b110 = new byte[1024 * 1200];
        b110 = null;
        System.out.println("16-------------------------------");
        byte[] b111 = new byte[1024 * 900];
        b111 = null;
        b111 = new byte[1024 * 900];
        b111 = null;

        System.out.println("3333333333333333333333333333333333333333333-------------------------------");

        System.out.println("-------------------------------");

                List<byte[]> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(int i=0; i<100000000; i++)
        {
            System.out.println("------------------------------- " +
                    i + " : "+(380 * (i + 1)) + "KB\t"  + formatter.format(new Date())
                    + "-------------------------------");
            list.add(new byte[1024 * 380]);

            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("App finalize be invoke.");
        App.app = this;
    }

    public static void runnableThread()
    {
        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        thread.start();
    }

    public static void threadThread()
    {
        ThreadThread threadThread = new ThreadThread();
        threadThread.start();
        try {
            threadThread.join(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadThread.getState());
    }

    public static void callabelFutur()
    {
        final FutureTask<Integer> future = new FutureTask<Integer>(new CallableFutur());

        Thread thread = new Thread(future);
        thread.start();

//        future.run();

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void volatialTest()
    {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i < 10; i++)
        {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < 10000; i++)
                    {
                        app.noVolatelTest++;
                        app.volatileTest++;
                    }
                }
            });

            threads.add(thread);
        }

        for(int i= 0; i < threads.size(); i++)
        {
            threads.get(i).start();
        }

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.activeCount());

        while (Thread.activeCount() > 2)
        {
//            System.out.println(Thread.activeCount());
            Thread.yield();
        }

        System.out.println(Thread.activeCount() + " " + app.noVolatelTest + " " + app.volatileTest);
    }


    public static void threadPoolSequence()
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("4");
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();

        System.out.println("shutdown.");
    }


    public static void synchronizedTest()
    {
        for(int i=0; i < 100; i++)
        {
            final int j = i;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (App.class) {
                        System.out.println(j);
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }).start();
        }
    }


    /**
     * 不做以下处理
     *
     *           if(Thread.interrupted())
     *                     {
     *                         break;
     *                     }
     *
     *
     * 中断无效
     */
    public static void interruptTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    System.out.println("run...");

                    if(Thread.interrupted())
                    {
                        break;
                    }
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(2 * 1000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void interruptTest2()
    {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true)
                        {
                            System.out.println("run...");
                            try {
                                Thread.sleep(5 * 1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        );

        thread.start();

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println("completed.");
    }


    public static void waitObjTest()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (App.class)
                {
                    try {
                        System.out.println("get app.class");
                        App.class.wait();
                        System.out.println("go on");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("release app.class");
        synchronized (App.class)
        {
            App.class.notify();
        }
    }

    public static void waitObjectNotifyallTest()
    {
        for (int i = 0; i < 100 ; i++)
        {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

//                    while (true)
//                    {


//                        try {
//                            Thread.sleep(100 * j);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }

                        synchronized (app)
                        {
                            System.out.println("thred " + j + " in");

                            try {
                                app.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            System.out.println("thred " + j + " out" + "--------------------------------------");
//                            try {
//                                Thread.sleep(100);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
//                    }
                }
            }).start();
        }

//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


            try {
                Thread.sleep(12 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            synchronized (app)
//            {
//                System.out.println("App.class.notify() in");
//                app.notifyAll();
//                System.out.println("App.class.notify() release");
//            }

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("App.class.notify() in");

                synchronized (app) {
                    app.notifyAll();
                }

//                for (int i = 0; i < 100; i++) {
//                    synchronized (app) {
//                        app.notify();
//                    }
//
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }

                System.out.println("App.class.notify() release");
            }
        }).start();


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * pool
     */
    public static void threadPoolTest()
    {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

}
