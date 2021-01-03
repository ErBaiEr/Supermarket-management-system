<%@ page import="com.course.bean.UserInfor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 二白、
  Date: 2021/1/3
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>Vistar - 翔氏集团</title>
    <link rel="stylesheet" type="text/css" href="assets/css/xh.css">
    <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/main2.css">

    <%
        List<UserInfor> userInfor = (List<UserInfor>) session.getAttribute("userInfor");
    %>
</head>

<body class="xh-oflow-h">
<div class="xh-main">
    <div class="xh-header">
        <h1 class="xh-fleft">XH后台管理系统</h1>
        <span style="padding-left: 50px"></span>
        <i class="fa fa-user-circle-o fa-fw"></i>
            <%
                if(userInfor!=null && userInfor.size()>0){
            %>

            <%= userInfor.get(0).getUser().getUname()%>

            <%
            }else{
            %>
            <%= "登录/注册"%>
            <%}%>

        <a href="/CourseSetting/MainIndexServlet" class="xh-fright"><i class="fa fa-home fa-fw"></i> 首页</a>
    </div>
    <div class="xh-content">
        <div class="xh-menu" style="height:672px">
            <ul>
                <a href="/CourseSetting/AllUserServlet" target="iframe">
                    <li class="xh-nav" xh-nav-id="#child-first">
                        <xh><i class="fa fa-home fa-fw"></i> 用户信息</xh>
                    </li>
                </a>

                <a href="/CourseSetting/AllGoodServlet" target="iframe">
                    <li class="xh-nav" xh-nav-id="#child-second">
                        <xh><i class="fa fa-codepen fa-fw"></i> 商品信息</xh>
                    </li>
                </a>

                <a href="/CourseSetting/AllCartServlet" target="iframe">
                    <li class="xh-nav" xh-nav-id="#child-third">
                        <xh><i class="fa fa-pagelines fa-fw"></i> 购物车信息</xh>
                    </li>
                </a>

                <a href="/CourseSetting/AllOrderServlet" target="iframe">
                    <li class="xh-nav">
                        <xh><i class="fa fa-phone fa-fw"></i> 订单信息</xh>
                    </li>
                </a>
            </ul>


        </div>
        <div class="xh-context" style="height:672px">

            <iframe name="iframe" src="/CourseSetting/AllUserServlet" class="xh-iframe" style="height:670px">

            </iframe>

        </div>
    </div>
</div>


</body>
</html>
