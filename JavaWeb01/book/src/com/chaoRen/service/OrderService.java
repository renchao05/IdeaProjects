package com.chaoRen.service;

import com.chaoRen.pojo.Cart;
import com.chaoRen.pojo.Order;
import com.chaoRen.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);

    public List<Order> showAllOrders();

    public List<OrderItem> showOrderDetail(String orderId);

    public List<Order> showMyOrders(Integer userId);

    public void sendOrder(String orderId);

    public void receiverOrder(String orderId);


}
