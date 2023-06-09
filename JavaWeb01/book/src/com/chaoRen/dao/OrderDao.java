package com.chaoRen.dao;

import com.chaoRen.pojo.Order;

import java.util.List;

public interface OrderDao {

    public int saveOrder(Order order);

    public List<Order> queryOrders();

    public List<Order> queryOrdersByUserId(Integer userId);

    public void changeOrderStatus(String orderId, Integer status);
}
