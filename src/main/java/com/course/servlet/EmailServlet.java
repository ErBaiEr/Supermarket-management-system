package com.course.servlet;

import com.course.Dao.UserDao;
import com.course.bean.Json_flag;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmailServlet")
public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        Json_flag f = new Json_flag();
        UserDao userDao = new UserDao();

        if(email != null){
            if(userDao.Seek_Email(email))
                f.setFlag(1);
            else f.setFlag(0);
        }
        Gson gson = new Gson();
        String result = gson.toJson(f);

        response.getWriter().write(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
