package com.chaoRen.web;

import com.chaoRen.pojo.Cart;
import com.chaoRen.pojo.Order;
import com.chaoRen.pojo.OrderItem;
import com.chaoRen.pojo.User;
import com.chaoRen.service.impl.OrderServiceImpl;
import com.chaoRen.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();

    /**
     * 结算创建 订单filter
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        User user =(User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/pages/user/login.jsp");
            return;
        }
        String order = orderService.createOrder(cart, user.getId());

        req.getSession().setAttribute("order",order);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }


    /**
     * 管理员后台显示所有订单
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrders();
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    /**
     * 查看订单详情
     */
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        List<OrderItem> orderItems = orderService.showOrderDetail(orderId);
        req.setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req,resp);
    }

    /**
     * 显示用户订单
     */
    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.showMyOrders(user.getId());
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    /**
     * 订单发货
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        resp.sendRedirect(req.getContextPath()+ "/orderServlet?action=showAllOrders");
    }

    /**
     * 确认收货
     */
    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.receiverOrder(orderId);
        resp.sendRedirect(req.getContextPath()+ "/orderServlet?action=showMyOrder");
    }
}
