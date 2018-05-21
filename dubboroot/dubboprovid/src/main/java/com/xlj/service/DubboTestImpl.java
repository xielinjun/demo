package com.xlj.service;

import com.alibaba.dubbo.rpc.Protocol;
import com.xlj.interfaces.DubboTest;
import com.xlj.interfaces.model.Order;
import com.xlj.interfaces.model.OrderDetial;
import com.xlj.interfaces.model.User;

import java.util.ArrayList;
import java.util.List;

public class DubboTestImpl implements DubboTest {
    @Override
    public List<Order> getUserOrders(User user) {

        System.out.println();
        System.out.println("----------------------");
        System.out.println("服务器收到调用: " + user);
        System.out.println("----------------------");
        System.out.println();

        List<Order> listResult = new ArrayList<Order>();
        for (int i = 0; i < 5; i++)
        {
            Order order = new Order();
            order.setAddress("add: " + i);
            order.setAmount(i);
            order.setCount(i);
            order.setUser(user);
            order.setDetials(new ArrayList<OrderDetial>());

            for(int j = 0; j < 5; j++)
            {
                OrderDetial orderDetial = new OrderDetial();

                orderDetial.setAmount(i+j);
                orderDetial.setArticName("name: " + i+j);
                orderDetial.setCount(i+j);
                orderDetial.setPrice(i+j);

                order.getDetials().add(orderDetial);
            }

            listResult.add(order);
        }

        return listResult;
    }

    @Override
    public void setProtocol(Protocol protocol) {
        System.out.println("impl: " + protocol);
    }
}