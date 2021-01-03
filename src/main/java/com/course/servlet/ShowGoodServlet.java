package com.course.servlet;

import com.course.Dao.GoodDao;
import com.course.bean.Good;
import com.course.bean.PageBean;
import com.course.bean.UserInfor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ShowGoodServlet")
public class ShowGoodServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        //管理当前页
        List<UserInfor> userInfor = (List<UserInfor>) request.getSession().getAttribute("userInfor");
        String currentPageStr = request.getParameter("currentPage");
        Integer currentPage = null;
        if (currentPageStr!=null && currentPageStr.length()>0){
            currentPage = Integer.valueOf(currentPageStr);
        } else{
            currentPage = 1;
        }

        //统计共有多少数据
        GoodDao goodDao = new GoodDao();
        Integer totalRows = goodDao.getCount();

        //当前页面应该显示的数据
        List<Good> goods = new ArrayList<Good>();
        goods =  goodDao.GetCurrentPageGoods(currentPage, 3);

        //放入pagebean中
        PageBean pageBean = new PageBean(currentPage,3,totalRows,goods);

        //将pagebean传到前端
        request.getSession().setAttribute("pageBean", pageBean);
        request.getSession().setAttribute("userInfor", userInfor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
        dispatcher.forward(request,response);

        /*String pageSize = request.getParameter("id");

        List<Good> goods = new ArrayList<Good>();

        GoodDao goodDao= new GoodDao();
        goods = goodDao.GetCurrentPageGoods(1);
        request.getSession().setAttribute("goods", goods);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/shop.jsp");
        dispatcher.forward(request,response);*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
