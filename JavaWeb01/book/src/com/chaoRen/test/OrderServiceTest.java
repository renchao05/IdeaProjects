package com.chaoRen.test;

import com.chaoRen.pojo.Cart;
import com.chaoRen.pojo.CartItem;
import com.chaoRen.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void createOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(5,"红楼梦1",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(6,"三国演义",1,new BigDecimal(100),new BigDecimal(100)));
        String order = orderService.createOrder(cart, 1);
        System.out.println("订单号：" + order);
    }
}