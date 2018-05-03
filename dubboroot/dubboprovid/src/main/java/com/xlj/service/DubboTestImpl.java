package com.xlj.service;

import com.xlj.interfaces.DubboTest;
import com.xlj.interfaces.model.Order;
import com.xlj.interfaces.model.User;

import java.util.List;

public class DubboTestImpl implements DubboTest {
    @Override
    public List<Order> getUserOrders(User user) {

        System.out.println();
        System.out.println("----------------------");
        System.out.println("服务器收到调用: " + user);
        System.out.println("----------------------");
        System.out.println();

        return null;
    }
}
