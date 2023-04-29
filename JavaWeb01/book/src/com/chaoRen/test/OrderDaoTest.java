package com.chaoRen.test;

import com.chaoRen.dao.impl.OrderDaoImpl;
import com.chaoRen.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDaoTest {
    OrderDaoImpl orderDao = new OrderDaoImpl();
    @Test
    void saveOrder() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.saveOrder(new Order("123456", new Date(), new BigDecimal(100), 0, 1));
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("16397113825491",0);
    }
}