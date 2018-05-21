package com.xlj.interfaces;

import com.alibaba.dubbo.common.extension.SPI;
import com.alibaba.dubbo.rpc.Protocol;
import com.xlj.interfaces.model.Order;
import com.xlj.interfaces.model.User;

import java.util.List;

@SPI
public interface DubboTest {

    List<Order> getUserOrders(User user);

    void setProtocol(Protocol protocol);

}
