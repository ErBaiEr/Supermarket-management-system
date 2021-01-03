package com.course.servlet;

import com.course.Dao.CartDao;
import com.course.Dao.GoodDao;
import com.course.Dao.UserDao;
import com.course.bean.Cart;
import com.course.bean.Good;
import com.course.bean.User;
import com.course.bean.UserInfor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        //获取前台的数据
        String uname = request.getParameter("username");
        String password =request.getParameter("password");

        User user = new User();

        //通过userdao看是否登陆成功
        UserDao userDao = new UserDao();
        user = userDao.SeekUser(uname, password);

        if (user != null && user.getUid() != null){
            /*//存储session
            request.getSession().setAttribute("uname",user);*/

            List<UserInfor> list = new ArrayList<UserInfor>();



            //查找购物车
            List<Cart> cartlist = new ArrayList<Cart>();
            CartDao cartDao = new CartDao();
            cartlist = cartDao.getUserCart(user.getUid());
            for (Cart cart : cartlist){
                Good good = new Good();
                UserInfor userInfor = new UserInfor();
                GoodDao goodDao = new GoodDao();
                good = goodDao.getGood(cart.getGid());
                userInfor.setUser(user);
                userInfor.setGood(good);
                userInfor.setNum(cart.getNum());
                list.add(userInfor);
            }
            if (cartlist == null || cartlist.size() <=0){
                UserInfor userInfor = new UserInfor();
                userInfor.setUser(user);
                list.add(userInfor);
            }
            request.getSession().setAttribute("userInfor",list);
            response.sendRedirect("/CourseSetting/index.jsp");
        }else {
            //清除session
            request.getSession().invalidate();
            PrintWriter writer = response.getWriter();
            writer.print("<script language='javascript'>");
            writer.print("alert('该用户名或密码错误,登录失败！');");
            writer.print("window.location.href = 'login.jsp';");
            writer.print("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
