<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>

    <%--静态包含base标签，css样式，jQuery文件--%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function () {
            $('#username').blur(function () {
                var username = this.value;
                if (username !== '') {
                    $.getJSON("<%=basePath%>UserServlet", "action=ajaxExistsUsername&username=" + username, function (data) {
                        if (data.existsUsername) {
                            $('.errorMsg').text('用户名已存在！');
                        } else {
                            $('.errorMsg').text('用户名可用！');
                        }
                    });
                }
            });


            $('#img_code').click(function () {
                this.src =  "<%=basePath%>kaptcha.jpg?da=" + parseInt(Math.random()*1000000);
            });
            $('#sub_btn').click(function () {
                var userStr = /^\w{5,12}$/;
                var emailStr = /^\w+@(\w+[.])+[a-zA-Z]+$/;
                var username = $('#username').val();
                var password = $('#password').val();
                var rePwd = $('#repwd').val();
                var email = $('#email').val();

                if (!userStr.test(username)) {
                    $('.errorMsg').text('用户名输入不合法！');
                } else if (!userStr.test(password)) {
                    $('.errorMsg').text('密码输入不合法！');
                } else if (!(password === rePwd)) {
                    $('.errorMsg').text('两次密码输入不一致!');
                } else if (!emailStr.test(email)) {
                    $('.errorMsg').text('邮箱输入不合法!');
                } else {
                    $('.errorMsg').text('');
                    return true;
                }
                return false;
            });
        });

    </script>

    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">${requestScope.msg}</span>
                </div>
                <div class="form">
                    <form action="UserServlet" method="post">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username" value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password" value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd" value="${requestScope.password}"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email" value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
                        <img id="img_code" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 80px; height: 40px">
                        <br/>
                        <br/>
                        <input type="hidden" name="action" value="register">
                        <input type="submit" value="注册" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--动态包含底部版权--%>
<%@include file="/pages/common/footer.jsp" %>

</body>
</html>