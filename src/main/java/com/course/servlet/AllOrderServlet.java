package com.course.servlet;

import com.course.Dao.SaleDao;
import com.course.Dao.UserDao;
import com.course.bean.AllOrder;
import com.course.bean.Sale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Sale> sales = new ArrayList<Sale>();
        SaleDao saleDao = new SaleDao();
        sales = saleDao.getAllSale();

        UserDao userDao = new UserDao();
        List<AllOrder> allOrders = new ArrayList<AllOrder>();
        for (Sale s : sales){
            AllOrder all = new AllOrder();
            all.setName(userDao.GetUname(s.getUid()));
            all.setList(s);
            allOrders.add(all);
        }

        request.getSession().setAttribute("sale",allOrders);

        request.getRequestDispatcher("/aorder.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
