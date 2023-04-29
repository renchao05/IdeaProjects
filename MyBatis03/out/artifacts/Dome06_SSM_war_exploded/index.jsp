<%--
  Created by IntelliJ IDEA.
  User: KEFU
  Date: 2022/1/20
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="users">显示所有用户列表</a><br>

<form action="addUser" method="post">
    用户名：<input type="text" name="userName"><br>
    密码：<input type="password" name="password"><br>
    邮箱：<input type="text" name="email"><br>
    <input type="submit" value="添加用户">
</form>
</body>
</html>
