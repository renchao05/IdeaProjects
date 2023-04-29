package com.chaoRen.service.impl;

import com.chaoRen.dao.OrderDao;
import com.chaoRen.dao.OrderItemDao;
import com.chaoRen.dao.impl.OrderDaoImpl;
import com.chaoRen.dao.impl.OrderItemDaoImpl;
import com.chaoRen.pojo.*;
import com.chaoRen.service.BookService;
import com.chaoRen.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookService bookService = new BookServiceImpl();

    //创建订单
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        orderDao.saveOrder(new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId));
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            CartItem value = entry.getValue();
            orderItemDao.saveOrderItem(new OrderItem(null,
                    value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice(), orderId));
            //更新图书销量和库存
            Book book = bookService.queryBookById(value.getId());
            book.setStock(book.getStock() - value.getCount());
            book.setSales(book.getSales() + value.getCount());
            bookService.updateBook(book);
        }


        cart.clear();
        return orderId;
    }

    //管理员后台显示订单
    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryOrders();
    }

    //查看订单详情
    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }


    //显示用户订单
    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    //管理员发货
    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }
    //用户确认收货
    @Override
    public void receiverOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }
}
