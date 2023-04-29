<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>

    <%--静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp" %>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>

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
        </tr>
        <c:set var="sumCount" value="0"/>
        <c:set var="sumPrice" value="0"/>
        <c:if test="${empty requestScope.orderItems}">

            <tr>
                <td colspan="5"><a href="">没有查询到该订单！</a></td>
            </tr>

        </c:if>

        <c:if test="${not empty requestScope.orderItems}">

            <c:forEach items="${requestScope.orderItems}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.count}</td>
                    <td>${item.price}</td>
                    <td>${item.totalPrice}</td>
                </tr>
                <c:set var="sumCount" value="${sumCount = sumCount + item.count}"/>
                <c:set var="sumPrice" value="${sumPrice = sumPrice + item.totalPrice}"/>
            </c:forEach>

        </c:if>

    </table>
    <c:if test="${not empty requestScope.orderItems}">
    <div class="cart_info">
        <span class="cart_span">共<span class="b_count">${sumCount}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${sumPrice}</span>元</span>
    </div>
    </c:if>
</div>


<%--动态包含底部版权--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>