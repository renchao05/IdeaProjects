package com.chaoRen.test;

import com.chaoRen.dao.OrderItemDao;
import com.chaoRen.dao.impl.OrderItemDaoImpl;
import com.chaoRen.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemDaoTest {
    OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
    @Test
    void saveOrderItem() {

        orderItemDao.saveOrderItem(new OrderItem(null, "三国演员", 1, new BigDecimal(55), new BigDecimal(55), "123456"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("16397113825491");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}