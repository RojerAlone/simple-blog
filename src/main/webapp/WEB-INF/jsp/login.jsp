<%--
  User: Alone
  Date: 2017/4/8
  Time: 18:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>用户登录</title>
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="common/top.jsp" />
    <div class="container">
        <form class="form-signin" action="/user/login" method="post">
            <h2 class="form-signin-heading">登录</h2>
            <label for="inputEmail" class="sr-only">用户名</label>
            <input type="text" id="inputEmail" class="form-control" placeholder="用户名" required autofocus>
            <label for="inputPassword" class="sr-only">密码</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </form>
    </div>
    <jsp:include page="common/bottom.jsp" />
</body>
</html>
