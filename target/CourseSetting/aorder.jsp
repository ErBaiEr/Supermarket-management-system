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
                        <c:forEach items="${sale}" var="sale">
                            <tr>
                                <td class="product-thumbnail"><span class="amount">
                                        ${sale.list.sid}
                                </span></td>

                                <td class="product-name"><span class="amount">
                                        ${sale.name}
                                </span></td>
                                <td class="product-price"><span class="amount">
                                        ${sale.list.rname}
                                </span></td>
                                <td class="product-quantity"><span class="amount">
                                        ${sale.list.gname}
                                </span></td>
                                <td class="product-subtotal"><span class="amount">
                                        ${sale.list.phone}
                                </span></td>
                                <td class="product-remove"><span class="amount">
                                        ${sale.list.raddress}
                                </span></td>
                                <td class="product-remove"><span class="amount">
                                        ${sale.list.remail}
                                </span></td>
                                <td class="product-remove"><span class="amount">
                                        ${sale.list.saledate}
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
