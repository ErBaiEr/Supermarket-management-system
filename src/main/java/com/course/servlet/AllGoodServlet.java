package com.course.servlet;

import com.course.Dao.GoodDao;
import com.course.bean.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@MultipartConfig
@WebServlet(urlPatterns = "/AllGoodServlet")
public class AllGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  gid = request.getParameter("gid");

        String goodid = request.getParameter("goodid");
        String gname = request.getParameter("gname");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String category = request.getParameter("category");

        String gname1 = request.getParameter("gname1");
        String price1 = request.getParameter("price1");
        String stock1 = request.getParameter("stock1");
        String category1 = request.getParameter("category1");

        List<Good> list = new ArrayList<Good>();
        GoodDao goodDao = new GoodDao();

        //商品添加
        if(gname1 != null && price1 != null && stock1 != null && category1 != null){

            Part part = request.getPart("picture1");
            String picture = getFileName(part);
            String dir ="G:\\CourseSetting\\src\\main\\webapp\\assets\\img\\product";
            File imgDir = new File(dir);

            if(!imgDir.exists()){
                imgDir.mkdirs();
            }

            //存储图片
            part.write(dir+"/"+picture);

            Good good = new Good();
            good.setGname(gname1);
            good.setPrice(Double.valueOf(price1));
            good.setCategory(category1);
            good.setStock(Integer.valueOf(stock1));
            good.setPicture("assets/img/product/"+picture);
            good.setEnterdate(new Date());

            goodDao.Add(good);
        }

        //商品修改
        if(goodid != null && Integer.valueOf(goodid) >= 0){
            Part part = request.getPart("picture");
            String picture = getFileName(part);

            String dir ="G:\\CourseSetting\\src\\main\\webapp\\assets\\img\\product";
            File imgDir = new File(dir);
            if(!imgDir.exists()){
                imgDir.mkdirs();
            }

            //存储图片
            part.write(dir+"/"+picture);

            //更改商品
            Good good = new Good();
            good.setGid(Integer.valueOf(goodid));
            good.setGname(gname);
            good.setPicture("assets/img/product/"+picture);
            good.setStock(Integer.valueOf(stock));
            good.setCategory(category);
            good.setPrice(Double.valueOf(price));
            good.setEnterdate(new Date());

            goodDao.Update(good);
        }

        //商品删除操作
        if(gid != null && Integer.valueOf(gid) >= 0){
            goodDao.Del(Integer.valueOf(gid));
        }

        list = goodDao.getAll();

        request.getSession().setAttribute("good",list);
        request.getRequestDispatcher("/agood.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private String getFileName(Part part) {
        String head = part.getHeader("Content-Disposition");
        String fileName = head.substring(head.indexOf("filename=\"")+10, head.lastIndexOf("\""));
        System.out.println(fileName);
        return fileName;
    }
}
