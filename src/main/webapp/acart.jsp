<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 二白、
  Date: 2021/1/2
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <title>Vistar - 翔氏集团</title>
    <link rel="stylesheet" type="text/css" href="assets/css/xh.css">
    <link rel="stylesheet" type="text/css" href="assets/css/main2.css">
    <link rel="stylesheet" href="assets/css/main.css">
</head>

<body>
<div class="xh-main">

    <div class="t-tab">

        <div class="tab-content">
            <form action="#">
                <div class="table-content table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th class="product-thumbnail">用户编号</th>
                            <th class="cart-product-name">用户名</th>
                            <th class="product-price">商品编号</th>
                            <th class="product-quantity">商品名</th>
                            <th class="product-subtotal">商品数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cart}" var="cart">
                            <tr>
                                <td class="product-thumbnail"><span class="amount">
                                        ${cart.uid}
                                </span></td>
                                <td class="product-name"><span class="amount">
                                        ${cart.uname}
                                </span></td>
                                <td class="product-price"><span class="amount">
                                        ${cart.gid}
                                </span></td>
                                <td class="product-quantity"><span class="amount">
                                        ${cart.gname}
                                </span></td>
                                <td class="product-subtotal"><span class="amount">
                                        ${cart.num}
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
</body>

</html>
