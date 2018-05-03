package com.xlj.interfaces;

import com.xlj.interfaces.model.Order;
import com.xlj.interfaces.model.User;

import java.util.List;

public interface DubboTest {

    List<Order> getUserOrders(User user);

}
