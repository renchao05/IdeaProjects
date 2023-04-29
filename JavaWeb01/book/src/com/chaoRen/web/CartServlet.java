package com.chaoRen.web;

import com.chaoRen.pojo.Book;
import com.chaoRen.pojo.Cart;
import com.chaoRen.pojo.CartItem;
import com.chaoRen.service.BookService;
import com.chaoRen.service.impl.BookServiceImpl;
import com.chaoRen.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CartServlet extends BaseServlet {

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart != null)
            cart.updateCount(id, count);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null)
            cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null)
            cart.deleteItem(WebUtils.parseInt(req.getParameter("id"), 0));
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        Book book = new BookServiceImpl().queryBookById(WebUtils.parseInt(req.getParameter("id"), 0));
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
        req.getSession().setAttribute("lestName",book.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

//    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cart cart = (Cart) req.getSession().getAttribute("cart");
//        if (cart == null) {
//            cart = new Cart();
//            req.getSession().setAttribute("cart", cart);
//        }
//        Book book = new BookServiceImpl().queryBookById(WebUtils.parseInt(req.getParameter("id"), 0));
//        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("lestName", book.getName());
//        map.put("count", cart.getTotalCount());
//        String json = new Gson().toJson(map, HashMap.class);
//        resp.getWriter().write(json);
//    }
}
