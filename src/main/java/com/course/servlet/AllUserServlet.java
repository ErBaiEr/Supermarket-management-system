package com.course.servlet;

import com.course.Dao.UserDao;
import com.course.bean.User;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AllUserServlet")
public class AllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");

        String userid = request.getParameter("userid");
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");

        String uname1 = request.getParameter("uname1");
        String email1 = request.getParameter("email1");
        String password1 = request.getParameter("password1");
        String address1 = request.getParameter("address1");

        List<User> list = new ArrayList<User>();
        UserDao userDao = new UserDao();

        if(uname1 != null && email1 != null && password1 != null){
            User user = new User();
            user.setUname(uname1);
            user.setEmail(email1);
            user.setPassword(password1);
            user.setAddress(address1);
            user.setType(1);
            userDao.AddUser(user);
        }

        //修改数据
        if(uname != null && email != null && password != null &&userid != null){
            userDao.UpdateUser(Integer.valueOf(userid),uname,email,password,address);
        }

        //删除数据
        if (uid != null && Integer.valueOf(uid) >= 0){
            userDao.DelUser(Integer.valueOf(uid));
        }

        list = userDao.GetAllUser();

        request.getSession().setAttribute("user",list);
        request.getRequestDispatcher("/auser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
