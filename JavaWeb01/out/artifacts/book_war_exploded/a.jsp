<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: KEFU
  Date: 2021/12/12
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="i" value="6"/>
<c:choose>
    <c:when test="${ i < 5}">
        <h1>第1个</h1>
    </c:when>
    <c:when test="${i < 10}">
        <h1>第2个</h1>
    </c:when>
</c:choose>

<h1>${i}</h1>
<c:forEach begin="1" end="5" var="i">
    <h2>第${i}行</h2>
</c:forEach>
</body>
</html>
