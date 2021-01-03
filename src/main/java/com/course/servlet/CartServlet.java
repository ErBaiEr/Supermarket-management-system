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

@WebServlet(urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfor> userInfor = (List<UserInfor>) request.getSession().getAttribute("userInfor");
        String Duid = request.getParameter("Duid");
        String Dgid = request.getParameter("Dgid");

        //判断是否要删除购物车商品
        if(Duid != null && Dgid != null){
            CartDao cartDao1 = new CartDao();
            cartDao1.DelCart(cartDao1.GetCid(Integer.valueOf(Duid),Integer.valueOf(Dgid)));
        }

        CartDao cartDao = new CartDao();
        List<Cart> list;
        List<UserInfor> userInfors = new ArrayList<UserInfor>();

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


        if (userInfor != null){
            if (userInfors.size() == 0){
                request.getSession().setAttribute("userInfor",userInfor);
            }else{
                request.getSession().setAttribute("userInfor",userInfors);
            }
        }

        //请求转发
        request.getRequestDispatcher("/cart.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
