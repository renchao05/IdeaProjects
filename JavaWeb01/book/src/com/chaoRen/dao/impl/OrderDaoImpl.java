package com.chaoRen.dao.impl;

import com.chaoRen.dao.OrderDao;
import com.chaoRen.pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order (order_id,create_time,price,`status`,user_id) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select * from t_order";
        return queryMulti(sql,Order.class);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql = "select * from t_order where user_id=?";
        return queryMulti(sql,Order.class,userId);
    }

    @Override
    public void changeOrderStatus(String orderId, Integer status) {
        String sql = "update t_order set `status`=? where order_id=?";
        update(sql, status,orderId);
    }

}
