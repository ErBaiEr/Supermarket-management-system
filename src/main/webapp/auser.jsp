<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 二白、
  Date: 2021/1/2
  Time: 15:40
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
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min_2.css">
    <link rel="stylesheet" href="assets/css/font-awesome_1.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    <script>
        $('#exampleModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget) // Button that triggered the modal
            var recipient = button.data('whatever') // Extract info from data-* attributes
            // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
            // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.

            var modal = $(this)
            modal.find('.modal-title').text('New message to ' + recipient)
            modal.find('.modal-body input').val(recipient)
        })

    </script>
</head>

<body>
<div class="xh-main">

    <div class="t-tab">

        <div class="tab-content">
            <form action="#">
                <div class="table-content table-responsive">
                    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#new">创建管理员</button>

                    <div class="modal fade" id="new" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel1">新增管理员信息</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form id="form1" action="/CourseSetting/AllUserServlet" method="post">
                                    <div class="modal-body">

                                        <div class="form-group">
                                            <label for="uname1" class="col-form-label">用户名:</label>
                                            <input type="text" class="form-control" id="uname1" name="uname1" placeholder="请输入用户名...">
                                        </div>
                                        <div class="form-group">
                                            <label for="email1" class="col-form-label">Email 地址:</label>
                                            <input type="text" class="form-control" id="email1" name="email1" placeholder="请输入邮箱账号...">
                                        </div>
                                        <div class="form-group">
                                            <label for="password1" class="col-form-label">密码:</label>
                                            <input type="password" class="form-control" id="password1" name="password1" placeholder="请输入密码...">
                                        </div>
                                        <div class="form-group">
                                            <label for="address1" class="col-form-label">家庭住址:</label>
                                            <input type="text" class="form-control" id="address1" name="address1" placeholder="请输入家庭住址...">
                                        </div>

                                        <script>
                                            function validate1(){
                                                var uname1 = document.getElementById("uname1").value;
                                                var email1 = document.getElementById("email1").value;
                                                var address1 = document.getElementById("address1").value;
                                                var password1 = document.getElementById("password1").value;
                                                var par1 = /^[A-Za-z0-9-._]+@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,6})$/;

                                                //通过par验证邮箱
                                                if(email1 ==''){
                                                    alert("邮箱不能为空！");
                                                    return false;
                                                }else if(!par1.test(email1)){
                                                    alert("邮箱格式不正确！");
                                                    return false;
                                                }

                                                //验证密码
                                                if (password1 == ''){
                                                    alert("密码不能为空！");
                                                    return false;
                                                }else  if (password1.length <6||password1.length >15){
                                                    alert("密码长度在6~15之间！");
                                                    return false;
                                                }

                                                //验证常住地
                                                if (address1.length >99){
                                                    alert("地址太长！");
                                                    return false;
                                                }

                                                //验证用户名
                                                if (uname1 == ''){
                                                    alert("用户名不能为空！");
                                                    return false;
                                                }else if (uname1 >49){
                                                    alert("用户名过长！");
                                                    return false;
                                                }
                                                return true;
                                            }
                                        </script>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                        <button type="submit" onclick="return validate1()" class="btn btn-primary">添加</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <table class="table">
                        <thead>
                        <tr>
                            <th class="product-thumbnail">用户编号</th>
                            <th class="cart-product-name">用户名</th>
                            <th class="product-price">Email 地址</th>
                            <th class="product-quantity">家庭住址</th>
                            <th class="product-subtotal">权限</th>
                            <th class="product-remove">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${user}" var="user">
                            <tr>
                                <td class="product-thumbnail"><span class="amount">
                                        ${user.uid}
                                </span></td>
                                <td class="product-name"><span class="amount">
                                        ${user.uname}
                                </span></td>
                                <td class="product-price"><span class="amount">
                                        ${user.email}
                                </span></td>
                                <td class="product-quantity"><span class="amount">
                                        ${user.address}
                                </span></td>
                                <td class="product-subtotal"><span class="amount">
                                    <c:choose>
                                        <c:when test="${user.type == 1}">
                                            管理员
                                        </c:when>
                                        <c:otherwise>
                                            用户
                                        </c:otherwise>
                                    </c:choose>

                                </span></td>
                                <td class="product-remove"><span class="amount">

                                    <a href="/CourseSetting/AllUserServlet?uid=${user.uid}"><i class="fa fa-times"></i></a>
                                    <span style="padding-left: 20px"></span>
                                    <a href="#" data-toggle="modal" data-target="#exampleModal_${user.uid}"><i class="fa fa-edit"></i></a>

                                </span></td>

                            </tr>
                            <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">Open modal for @fat</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Open modal for @getbootstrap</button>--%>

                            <div class="modal fade" id="exampleModal_${user.uid}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">修改用户信息</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form id="form_${user.uid}" action="/CourseSetting/AllUserServlet" method="post">
                                        <div class="modal-body">


                                                <div class="form-group">
                                                    <label for="userid" class="col-form-label">用户编号:</label>
                                                    <input  type="text" class="form-control" id="userid" name="userid" value="${user.uid}" readonly=“readonly”>
                                                </div>
                                                <div class="form-group">
                                                    <label for="uname_${user.uid}" class="col-form-label">用户名:</label>
                                                    <input type="text" class="form-control" id="uname_${user.uid}" name="uname" placeholder="${user.uname}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="email_${user.uid}" class="col-form-label">Email 地址:</label>
                                                    <input type="text" class="form-control" id="email_${user.uid}" name="email" placeholder="${user.email}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="password_${user.uid}" class="col-form-label">密码:</label>
                                                    <input type="text" class="form-control" id="password_${user.uid}" name="password" placeholder="${user.password}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="address_${user.uid}" class="col-form-label">家庭住址:</label>
                                                    <input type="text" class="form-control" id="address_${user.uid}" name="address" placeholder="${user.address}">
                                                </div>

                                            <script>
                                                function validate_${user.uid}(){
                                                    var uname = document.getElementById("uname_${user.uid}").value;
                                                    var email = document.getElementById("email_${user.uid}").value;
                                                    var address = document.getElementById("address_${user.uid}").value;
                                                    var password = document.getElementById("password_${user.uid}").value;
                                                    var par = /^[A-Za-z0-9-._]+@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,6})$/;

                                                    //通过par验证邮箱
                                                    if(email ==''){
                                                        alert("邮箱不能为空！");
                                                        return false;
                                                    }else if(!par.test(email)){
                                                        alert("邮箱格式不正确！");
                                                        return false;
                                                    }

                                                    //验证密码
                                                    if (password == ''){
                                                        alert("密码不能为空！");
                                                        return false;
                                                    }else  if (password.length <6||password.length >15){
                                                        alert("密码长度在6~15之间！");
                                                        return false;
                                                    }

                                                    //验证常住地
                                                    if (address.length >99){
                                                        alert("地址太长！");
                                                        return false;
                                                    }

                                                    //验证用户名
                                                    if (uname == ''){
                                                        alert("用户名不能为空！");
                                                        return false;
                                                    }else if (uname >49){
                                                        alert("用户名过长！");
                                                        return false;
                                                    }
                                                    return true;
                                                }
                                            </script>

                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                            <button type="submit" onclick="return validate_${user.uid}()" class="btn btn-primary">修改</button>
                                        </div>
                                    </form>
                                    </div>
                                </div>
                            </div>
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
