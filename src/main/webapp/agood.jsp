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

                <div class="table-content table-responsive">
                    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#new">创建商品</button>

                    <div class="modal fade" id="new" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel1">创建新商品</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form id="form" action="/CourseSetting/AllGoodServlet" method="post" enctype="multipart/form-data">
                                    <div class="modal-body">
                                        <div class="form-group">
                                            <label for="gname1" class="col-form-label">商品名称:</label>
                                            <input type="text" class="form-control" id="gname1" name="gname1" placeholder="请输入商品名...">
                                        </div>
                                        <div class="form-group">
                                            <label for="picture1" class="col-form-label">商品图片:</label>
                                            <input type="file" class="form-control" id="picture1" name="picture1" value="上传照片">
                                        </div>
                                        <div class="form-group">
                                            <label for="price1" class="col-form-label">价格:</label>
                                            <input type="text" class="form-control" id="price1" name="price1" placeholder="请输入价格...">
                                        </div>
                                        <div class="form-group">
                                            <label for="stock1" class="col-form-label">库存:</label>
                                            <input type="text" class="form-control" id="stock1" name="stock1" placeholder="请输入库存...">
                                        </div>
                                        <div class="form-group">
                                            <label for="category1" class="col-form-label">种类:</label>
                                            <input type="text" class="form-control" id="category1" name="category1" placeholder="请输入种类...">
                                        </div>

                                        <script>
                                            function validate1(){
                                                var gname = document.getElementById("gname1").value;
                                                var price = document.getElementById("price1").value;
                                                var picture = document.getElementById("picture1").value;
                                                var stock = document.getElementById("stock1").value;
                                                var category = document.getElementById("category1").value;

                                                var flag = /^(0|[1-9][0-9]*)$/;
                                                var flag_1 = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;

                                                if(gname ==''){
                                                    alert("商品名称不能为空！");
                                                    return false;
                                                }

                                                if (price == ''){
                                                    alert("价格不能为空！");
                                                    return false;
                                                }else if (!flag_1.test(price)){
                                                    alert("价格格式不正确！！");
                                                    return false;
                                                }

                                                if (picture == ''){
                                                    alert("图片不能为空！");
                                                    return false;
                                                }

                                                //验证常住地
                                                if (stock == ''){
                                                    alert("库存为空（可填0）！");
                                                    return false;
                                                } if(!flag.test(stock)){
                                                    alert("库存格式不正确！！");
                                                    return false;
                                                }

                                                //验证用户名
                                                if (category == ''){
                                                    alert("种类不能为空！");
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
                            <th class="product-thumbnail">商品编号</th>
                            <th class="cart-product-name">商品图片</th>
                            <th class="product-price">商品名称</th>
                            <th class="product-quantity">价格</th>
                            <th class="product-quantity">库存</th>
                            <th class="product-subtotal">种类</th>
                            <th class="product-subtotal">进货时间</th>
                            <th class="product-remove">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${good}" var="good">
                            <tr>
                                <td class="product-thumbnail"><span class="amount">
                                        ${good.gid}
                                </span></td>
                                <td class="product-name"><span class="amount">
                                    <img width="88px" height="88px" src="${good.picture}">
                                </span></td>
                                <td class="product-price"><span class="amount">
                                        ${good.gname}
                                </span></td>
                                <td class="product-price"><span class="amount">
                                        ￥ ${good.price}
                                </span></td>
                                <td class="product-quantity"><span class="amount">
                                        ${good.stock}
                                </span></td>
                                <td class="product-subtotal"><span class="amount">
                                        ${good.category}
                                </span></td>
                                <td class="product-subtotal"><span class="amount">
                                        ${good.enterdate}
                                </span></td>
                                <td class="product-remove"><span class="amount">

                                    <a href="/CourseSetting/AllGoodServlet?gid=${good.gid}"><i class="fa fa-times"></i></a>
                                    <span style="padding-left: 20px"></span>
                                    <a href="#" data-toggle="modal" data-target="#exampleModal_${good.gid}"><i class="fa fa-edit"></i></a>

                                </span></td>

                            </tr>
                            <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@fat">Open modal for @fat</button>
                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@getbootstrap">Open modal for @getbootstrap</button>--%>

                            <div class="modal fade" id="exampleModal_${good.gid}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">修改商品信息</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <form id="form_${good.gid}" action="/CourseSetting/AllGoodServlet" method="post" enctype="multipart/form-data">
                                            <div class="modal-body">


                                                <div class="form-group">
                                                    <label for="goodid" class="col-form-label">用户编号:</label>
                                                    <input  type="text" class="form-control" id="goodid" name="goodid" value="${good.gid}" readonly=“readonly”>
                                                </div>
                                                <div class="form-group">
                                                    <label for="gname_${good.gid}" class="col-form-label">商品名称:</label>
                                                    <input type="text" class="form-control" id="gname_${good.gid}" name="gname" placeholder="${good.gname}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="picture_${good.gid}" class="col-form-label">商品图片:</label>
                                                    <input type="file" class="form-control" id="picture_${good.gid}" name="picture" value="上传照片">
                                                </div>
                                                <div class="form-group">
                                                    <label for="price_${good.gid}" class="col-form-label">价格:</label>
                                                    <input type="text" class="form-control" id="price_${good.gid}" name="price" placeholder="${good.price}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="stock_${good.gid}" class="col-form-label">库存:</label>
                                                    <input type="text" class="form-control" id="stock_${good.gid}" name="stock" placeholder="${good.stock}">
                                                </div>
                                                <div class="form-group">
                                                    <label for="category_${good.gid}" class="col-form-label">种类:</label>
                                                    <input type="text" class="form-control" id="category_${good.gid}" name="category" placeholder="${good.category}">
                                                </div>

                                                <script>
                                                    function validate_${good.gid}(){
                                                        var gname = document.getElementById("gname_${good.gid}").value;
                                                        var price = document.getElementById("price_${good.gid}").value;
                                                        var picture = document.getElementById("picture_${good.gid}").value;
                                                        var stock = document.getElementById("stock_${good.gid}").value;
                                                        var category = document.getElementById("category_${good.gid}").value;

                                                        var flag = /^(0|[1-9][0-9]*)$/;
                                                        var flag_1 = /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/;

                                                        if(gname ==''){
                                                            alert("商品名称不能为空！");
                                                            return false;
                                                        }

                                                        if (price == ''){
                                                            alert("价格不能为空！");
                                                            return false;
                                                        }else if (!flag_1.test(price)){
                                                            alert("价格格式不正确！！");
                                                            return false;
                                                        }

                                                        if (picture == ''){
                                                            alert("图片不能为空！");
                                                            return false;
                                                        }

                                                        //验证常住地
                                                        if (stock == ''){
                                                            alert("库存为空（可填0）！");
                                                            return false;
                                                        } if(!flag.test(stock)){
                                                            alert("库存格式不正确！！");
                                                            return false;
                                                        }

                                                        //验证用户名
                                                        if (category == ''){
                                                            alert("种类不能为空！");
                                                            return false;
                                                        }
                                                        return true;
                                                    }
                                                </script>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                                <button type="submit" onclick="return validate_${good.gid}()" class="btn btn-primary">修改</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                        </tbody>
                    </table>

                </div>

        </div>

    </div>
</div>
</body>

</html>
