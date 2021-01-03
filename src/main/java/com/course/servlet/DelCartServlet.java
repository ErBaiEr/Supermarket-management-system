package com.course.servlet;

import com.course.Dao.CartDao;
import com.course.Dao.GoodDao;
import com.course.bean.Cart;
import com.course.bean.Good;
import com.course.bean.UserInfor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/DelCartServlet")
public class DelCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfor> userInfor = (List<UserInfor>) request.getSession().getAttribute("userInfor");

        String uid = request.getParameter("uid");
        String gid = request.getParameter("gid");
        String path = request.getParameter("path");

        List<UserInfor> userInfors = new ArrayList<UserInfor>();
        List<Cart> list = new ArrayList<Cart>();
        CartDao cartDao = new CartDao();

        if(uid != null && gid != null){
            CartDao cartDao1 = new CartDao();
            cartDao1.DelCart(cartDao1.GetCid(Integer.valueOf(uid),Integer.valueOf(gid)));
        }

        if (userInfor != null){
            //重新从数据库封装userInfor
            list = cartDao.getUserCart(userInfor.get(0).getUser().getUid());

            for (Cart c : list){
                UserInfor ui = new UserInfor();
                Good good = new Good();
                GoodDao goodDao = new GoodDao();
                good = goodDao.getGood(c.getGid());
                ui.setUser(userInfor.get(0).getUser());
                ui.setGood(good);
                ui.setNum(c.getNum());
                userInfors.add(ui);
            }
        }



        request.getSession().setAttribute("userInfor", userInfors);

        //谁发过来就发过去
        String servletPath = request.getServletPath();
        request.getRequestDispatcher("/"+path).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
