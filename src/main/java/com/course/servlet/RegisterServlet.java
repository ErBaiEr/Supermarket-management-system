package com.course.servlet;

import com.course.Dao.UserDao;
import com.course.bean.Json_flag;
import com.course.bean.User;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String email_flag = request.getParameter("email");

        //获取前台的数据
        String uname = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        //进行封装
        User user = new User(null,uname,email,password,address,0);
        //保存到数据库
        UserDao userDao = new UserDao();

        //是否注册成功
        boolean flag = userDao.AddUser(user) != 0 ? true:false;

        //如果成功重定向，如果失败返回注册界面
        if (flag){
            response.sendRedirect("/CourseSetting/login.jsp");
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
            dispatcher.forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
