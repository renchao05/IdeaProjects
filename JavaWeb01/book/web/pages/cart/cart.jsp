<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>

    <%--静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        $(function () {
            $('#clearCart').click(function () {
                return confirm('您确定要清空购物车吗？')
            });

            $('a.deleteItem').click(function () {
                return confirm('亲确定要删除【' + $(this).parent().parent().find("td:first").text() + '】吗？');
            });

            $('.updateCount').change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = $(this).val();
                var id = $(this).attr('bookId');

                if (confirm('您确定要修改【 ' + name + ' 】数量为:' + count + ' 吗？')) {
                    location.href = '<%=basePath%>cartServlet?action=updateCount&id=' + id + '&count=' + count;
                } else {
                    this.value = this.defaultValue;
                }
            });
        });

    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>

    <%--静态包含head--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">

            <tr>
                <td colspan="5"><a href="">亲，购物车没有商品！去浏览商品吧！</a></td>
            </tr>

        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">

            <c:forEach items="${sessionScope.cart.items}" var="item">
                <tr>
                    <td>${item.value.name}</td>
                    <td>
                        <input bookid="${item.value.id}" class="updateCount" style="width: 30px" type="text" value="${item.value.count}">
                    </td>
                    <td>${item.value.price}</td>
                    <td>${item.value.totalPrice}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${item.value.id}">删除</a></td>
                </tr>
            </c:forEach>

        </c:if>

    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>


<%--动态包含底部版权--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>