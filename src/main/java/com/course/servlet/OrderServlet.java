package com.course.servlet;

import com.course.Dao.CartDao;
import com.course.Dao.GoodDao;
import com.course.Dao.SaleDao;
import com.course.bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        List<UserInfor> userInfor = (List<UserInfor>) request.getSession().getAttribute("userInfor");
        String rname = request.getParameter("uname");
        String raddress = request.getParameter("address");
        String remail = request.getParameter("email");
        String phone = request.getParameter("phone");

        //封装该用户的订单信息，并清除购物车
        UserOrder userOrder = new UserOrder();
        CartDao cartDao = new CartDao();
        List<Sale> list = new ArrayList<Sale>();
        List<Cart> list1 = new ArrayList<Cart>();
        List<UserInfor> userInfors = new ArrayList<UserInfor>();
        SaleDao saleDao = new SaleDao();
        if (userInfor != null && userInfor.get(0).getGood() != null){
            Double num = 0.0;
            for (UserInfor ui : userInfor){
                Sale sale = new Sale();

                sale.setUid(ui.getUser().getUid());
                sale.setRname(rname);
                sale.setGname(ui.getGood().getGname());
                sale.setPhone(phone);
                sale.setRaddress(raddress);
                sale.setRemail(remail);
                //获取当前时间
                sale.setSaledate(new Date());
                sale.setSid(saleDao.Add(sale));
                list.add(sale);
                num += ui.getNum()*ui.getGood().getPrice();
                //删除购物车
                cartDao.DelCart(cartDao.GetCid(ui.getUser().getUid(),ui.getGood().getGid()));
            }
            userOrder.setSale(list);
            userOrder.setNum(num);

        }
        User user = new User();
        user = userInfor.get(0).getUser();
        UserInfor userInfor1 = new UserInfor();
        userInfor1.setUser(user);
        userInfors.add(userInfor1);

        List<Sale> list2 = new ArrayList<Sale>();
        list2 = saleDao.getAll(userInfor.get(0).getUser().getUid());

        if (userInfor != null){
            request.getSession().setAttribute("userInfor",userInfors);
        }

        request.getSession().setAttribute("userOrder",list2);

        //请求转发
        request.getRequestDispatcher("/order.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
