package com.chaoRen.dao.impl;

import com.chaoRen.dao.OrderItemDao;
import com.chaoRen.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (`name`,`count`,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(),
                orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select * from t_order_item where order_id=?";
        return queryMulti(sql,OrderItem.class,orderId);
    }
}
