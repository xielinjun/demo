package com.xlj;

import com.alibaba.dubbo.rpc.RpcContext;
import com.xlj.interfaces.DubboTest;
import com.xlj.interfaces.model.Order;
import com.xlj.interfaces.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubboconsumer.xml");

        System.out.println("--------------------------------------------------");

        System.out.println(((DubboTest)context.getBean("dubboTest")).getUserOrders(new User()));

        System.out.println("");

        DubboTest dubboTestV2 = ((DubboTest)context.getBean("dubboTestV2"));
        dubboTestV2.getUserOrders(new User());
        Future<List<Order>> orders = RpcContext.getContext().getFuture();

        System.out.println(orders.get());

//        Future<DubboTest> futureDubooTestV2 = RpcContext.getContext().getFuture();
//        futureDubooTestV2.get().getUserOrders(new User());

        System.out.println("--------------------------------------------------");

        System.in.read();
    }
}
