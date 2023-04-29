package com.chaoRen.test;

import com.chaoRen.pojo.Cart;
import com.chaoRen.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart = new Cart();

    @Test
    void addItem() {
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(6,"三国演义",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(6,"西游记",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(6);
        System.out.println(cart);
    }

    @Test
    void clear() {
        cart.addItem(new CartItem(5,"红楼梦",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(5,"红楼梦2",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(6,"西游记",1,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateCount() {
        cart.addItem(new CartItem(5,"红楼梦2",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(5,"红楼梦2",1,new BigDecimal(66),new BigDecimal(66)));
        cart.addItem(new CartItem(6,"西游记",1,new BigDecimal(100),new BigDecimal(100)));
        cart.updateCount(5,10);
        System.out.println(cart);
    }
}