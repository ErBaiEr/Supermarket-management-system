<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.course.bean.UserInfor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: 二白、
  Date: 2021/1/1
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html class="no-js" lang="ZXX">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Vistar - 翔氏集团</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="manifest" href="site.webmanifest">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/dripicons.css">
    <link rel="stylesheet" href="assets/css/meanmenu.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
</head>

<script>
    function fun(){
        if (${userInfor == null}){
            alert("请先登录");
            return false
        }
        return true;
    }
    <%
        List<UserInfor> userInfor = (List<UserInfor>) session.getAttribute("userInfor");
    %>
    function buy(){
        if (<%=userInfor == null%>){
            alert("请先登录");
            return false
        }if(<%=userInfor != null && userInfor.get(0).getGood() == null%>){
            alert("购物车暂无商品");
            return false;
        }
        return true;
    }
</script>

<body>

<!--头部-->
<header>
    <div class="header-top-area pl-55 pr-55 d-none d-lg-block">
        <div class="container-fluid">
            <%--最顶部--%>
            <div class="row">
                <div class="col-xl-6 col-lg-6 d-none d-lg-block">
                    <div class="header-info">
                        <span><i class="dripicons-phone"></i> Call : 17711671157</span>
                        <span><i class="dripicons-mail"></i> [2603825166@qq.com]</span>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-6">
                    <div class="header-right d-none d-lg-block">
                        <div class="header-login  f-right">
                            <a href="/CourseSetting/login.jsp"><i class="dripicons-lock"></i>
                                <%
                                    if(userInfor!=null && userInfor.size()>0){
                                %>

                                <%= userInfor.get(0).getUser().getUname()%>

                                <%
                                }else{
                                %>
                                <%= "登录/注册"%>
                                <%}%>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--菜单栏--%>
    <div id="sticky-header" class="main-menu-area pl-55 pr-55">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xl-3 col-lg-2 d-flex align-items-center">
                    <div class="logo">
                        <a href="index.html"><img src="assets/img/logo/logo.png" alt="" /></a>
                    </div>
                </div>
                <div class="col-xl-6 col-lg-7">
                    <div class="header-search f-right d-none d-xl-block">
                        <form class="header-search-form">
                            <input placeholder="搜索" type="text">
                            <button type="submit"><i class="dripicons-search"></i></button>
                        </form>
                    </div>
                    <div class="main-menu text-center">
                        <nav id="mobile-menu">
                            <ul>
                                <li class="active"><a href="/CourseSetting/index.jsp">主页</a>
                                </li>
                                <li><a href="/CourseSetting/ShowGoodServlet">超市商品主页</a>
                                </li>
                                <li><a href="#">其他页面</a>
                                    <ul class="sub-menu text-left">
                                        <li><a href="/CourseSetting/login.jsp">登录</a></li>
                                        <li><a href="/CourseSetting/register.jsp">注册</a></li>
                                        <li><a onclick="return fun()" href="/CourseSetting/CartServlet">购物车</a></li>
                                        <li><a onclick="return buy()" href="/CourseSetting/CheckoutServlet">付款</a></li>
                                        <li><a onclick="return fun()" href="/CourseSetting/OrderServlet">订单</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-3">
                    <div class="header-2-right f-right d-none d-md-none d-lg-block">
                        <ul>
                            <c:choose>

                            <c:when test="${userInfor != null && userInfor.get(0).getGood() != null}">
                            <li class="d-shop-cart"><a href="#"><i class="dripicons-cart"></i> <span class="cart-count"><%=userInfor.size()%></span></a>
                                </c:when>

                                <c:otherwise>
                            <li class="d-shop-cart"><a href="#"><i class="dripicons-cart"></i> </a>
                                </c:otherwise>

                                </c:choose>
                                <ul class="minicart">
                                    <c:if test="${userInfor != null && userInfor.get(0).getGood() != null}">
                                        <c:forEach items="${userInfor}" var="infor">
                                            <li>
                                                <div class="cart-img">
                                                    <img width="85px" height="100px" src="${infor.good.picture}" alt="">
                                                </div>
                                                <div class="cart-content">
                                                    <h3>
                                                        ${infor.good.gname}
                                                    </h3>
                                                    <div class="cart-price">
                                                        <span class="newss ">￥ ${infor.good.price}</span>
                                                    </div>
                                                    <div class="cart-price">
                                                        <span class="category ">商品种类: ${infor.good.category}</span>
                                                    </div>
                                                    <div class="cart-price">
                                                        <span class="num ">数量: ${infor.num}</span>
                                                    </div>
                                                </div>
                                                <div class="del-icon">
                                                    <a href="/CourseSetting/DelCartServlet?uid=${infor.user.uid}&gid=${infor.good.gid}&path=order.jsp">
                                                        <i class="far fa-trash-alt"></i>
                                                    </a>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </c:if>

                                    <li>
                                        <div class="total-price">
                                            <span class="f-left">Total:</span>
                                            <span class="f-right">￥
                                            <%
                                                double total = 0;
                                                if (userInfor != null && userInfor.get(0).getGood() != null){
                                                    for (int i = 0; i<userInfor.size(); i++){
                                                        total += userInfor.get(i).getNum()*userInfor.get(i).getGood().getPrice();
                                                    }
                                                }
                                                NumberFormat nf = NumberFormat.getNumberInstance();
                                                //digits 显示的数字位数 为格式化对象设定小数点后的显示的最多位,显示的最后位是舍入的
                                                nf.setMaximumFractionDigits(2);

                                            %>
                                                <%=nf.format(total)%>

                                            </span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="checkout-link">
                                            <a href="/CourseSetting/CartServlet" onclick="return fun()">Shopping Cart</a>
                                            <a onclick="return buy()" href="/CourseSetting/CheckoutServlet">Checkout</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-bar info-bar"><a href="#"><i class="dripicons-vibrate"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-12">
                    <div class="mobile-menu"></div>
                </div>
            </div>
        </div>
    </div>

    <%--简介按钮--%>
    <div class="extra-info">
        <div class="close-icon">
            <button>
                <i class="far fa-window-close"></i>
            </button>
        </div>
        <div class="logo-side mb-30">
            <a href="index.html">
                <img src="assets/img/logo/white.png" alt="" />
            </a>
        </div>
        <div class="side-info mb-30">
            <div class="contact-list mb-30">
                <h4>服务宗旨</h4>
                <p>一切为了生活</p>
            </div>
            <div class="contact-list mb-30">
                <h4>联系电话</h4>
                <p>17711671157</p>
            </div>
            <div class="contact-list mb-30">
                <h4>官方邮箱</h4>
                <p>[2603825166@qq.com]</p>
            </div>
        </div>
        <div class="instagram">
            <img height="88px" src="assets/img/portfolio/index01.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index02.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index03.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index04.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index05.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index06.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index07.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index08.jpg" alt="">
            <img height="88px" src="assets/img/portfolio/index09.jpg" alt="">
        </div>
    </div>
</header>


<main>

    <div class="breadcrumb-area grey-bg pt-155 pb-155">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="breadcrumb-text text-center">
                        <h1>订单</h1>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <section class="cart-area pt-100 pb-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="#">
                        <div class="table-content table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="product-thumbnail">订单号</th>
                                    <th class="cart-product-name">寄件人姓名</th>
                                    <th class="product-price">收件人姓名</th>
                                    <th class="product-quantity">商品名</th>
                                    <th class="product-subtotal">电话号码</th>
                                    <th class="product-remove">收件人地址</th>
                                    <th class="product-remove">收件人邮箱</th>
                                    <th class="product-remove">销售日期</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userOrder}" var="sale">
                                <tr>
                                    <td class="product-thumbnail"><span class="amount">
                                        ${sale.sid}
                                    </span></td>

                                    <td class="product-name"><span class="amount">
                                        <%= userInfor.get(0).getUser().getUname()%>
                                    </span></td>
                                    <td class="product-price"><span class="amount">
                                        ${sale.rname}
                                    </span></td>
                                    <td class="product-quantity"><span class="amount">
                                        ${sale.gname}
                                    </span></td>
                                    <td class="product-subtotal"><span class="amount">
                                        ${sale.phone}
                                    </span></td>
                                    <td class="product-remove"><span class="amount">
                                        ${sale.raddress}
                                    </span></td>
                                    <td class="product-remove"><span class="amount">
                                        ${sale.remail}
                                    </span></td>
                                    <td class="product-remove"><span class="amount">
                                        ${sale.saledate}
                                    </span></td>
                                </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>

</main>

<%--尾部--%>
<footer>
    <div class="footer-area pt-80 pb-120">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-md-6">
                    <div class="footer-wrapper mb-30">
                        <div class="footer-logo">
                            <a href="index.html"><img src="assets/img/logo/logo.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <%--                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="footer-wrapper mb-30">
                                        <h4 class="footer-title">Quick Link</h4>
                                        <ul class="footer-menu footer-2-menu">
                                            <li><a href="#">About us</a></li>
                                            <li><a href="#">term</a></li>
                                            <li><a href="#">policy</a></li>
                                            <li><a href="#">service</a></li>
                                            <li><a href="#">My Account</a></li>
                                            <li><a href="#">Checkout</a></li>
                                            <li><a href="#">Order tracking</a></li>
                                            <li><a href="#">Help & Support</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-xl-3 col-lg-2 col-md-6">
                                    <div class="footer-wrapper mb-30">
                                        <h4 class="footer-title">Contact Us</h4>
                                        <ul class="footer-link">
                                            <li>Sagrada Familia, Herba <br>
                                                Street Front USA</li>
                                            <li><a href="/cdn-cgi/l/email-protection" class="__cf_email__" data-cfemail="1e7f7a7377705e7b667f736e727b307d7173">[email&#160;protected]</a></li>
                                            <li>002- 01008431112</li>
                                        </ul>
                                    </div>
                                </div>--%>
                <div class="event-text">
                    <div class="footer-wrapper mb-30 ml-70">
                        <h4 class="footer-title">关于 生活</h4>
                        <%--<ul class="footer-menu">
                            <li><a href="#">Facebook/Vistar</a></li>
                            <li><a href="#">Twitter/Vistar</a></li>
                            <li><a href="#">Linkdin/Vistar</a></li>
                            <li><a href="#">Skype_Vistar</a></li>
                        </ul>--%>
                        常听到有人抱怨生活，抱怨这个社会。说现在美的事物越来越少，生活也越来越没意思。我想每天抱着“做一天和尚，撞一天钟”的想法过生活，当然会感到厌倦，对生活失去热情，就从前半年发生的玉树大地震来说，各地救援第一时间赶赴现场进行救援，有些人甚至徒手挖废墟，在极其恶劣的气候条件下拯救伤员。那种坚持让我们为之动容，我想这就是美，是最崇高的美。
                        <br>
                        <br>
                        生活非常严酷，有时人是寸步难行的，容不下任何妄念。除了让自己通过学习和理解，并因此改变，没有任何捷径。礼物有可能出其不意地到来，但自己必须先清空成容器。保持天真。有时要耐心地等一等。最好爱一个值得尊敬的人，并且是有些傻气地爱着他。爱有时就是一种相信。
                    </div>
                </div>
            </div>
        </div>
        <div class="footer-bottom-area pt-25">
            <div class="container">
                <div class="row">
                    <div class="col-xl-8 col-lg-8 col-md-8">
                        <div class="copyright">
                            <p>  <i class="far fa-copyright"></i> 2018 阿翔 版权所有</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>

<script src="assets/js/vendor/modernizr-3.5.0.min.js"></script>
<script src="assets/js/vendor/jquery-1.12.4.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/isotope.pkgd.min.js"></script>
<script src="assets/js/jquery.countdown.min.js"></script>
<script src="assets/js/slick.min.js"></script>
<script src="assets/js/jquery.meanmenu.min.js"></script>
<script src="assets/js/ajax-form.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/js/jquery.scrollUp.min.js"></script>
<script src="assets/js/imagesloaded.pkgd.min.js"></script>
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<script src="assets/js/plugins.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>
