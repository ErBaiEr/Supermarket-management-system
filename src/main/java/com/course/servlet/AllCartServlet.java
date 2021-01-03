package com.course.servlet;

import com.course.Dao.CartDao;
import com.course.Dao.GoodDao;
import com.course.Dao.UserDao;
import com.course.bean.AllCart;
import com.course.bean.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AllCartServlet")
public class AllCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<AllCart> list = new ArrayList<AllCart>();
        List<Cart> list1 = new ArrayList<Cart>();
        CartDao cartDao = new CartDao();
        GoodDao goodDao = new GoodDao();
        UserDao userDao = new UserDao();

        list1 = cartDao.GetAllCart();
        for (Cart c : list1){
            AllCart allCart = new AllCart();
            allCart.setGid(c.getGid());
            allCart.setGname(goodDao.getGood(c.getGid()).getGname());
            allCart.setUid(c.getUid());
            allCart.setUname(userDao.GetUname(c.getUid()));
            allCart.setNum(c.getNum());
            list.add(allCart);
        }

        request.getSession().setAttribute("cart", list);
        request.getRequestDispatcher("/acart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
