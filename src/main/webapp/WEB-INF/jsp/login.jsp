<%--
  User: Alone
  Date: 2017/4/8
  Time: 18:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <c:if test="${info != null}">
        <h1>${info}</h1>
    </c:if>
    <form action="/user/login" method="post">
        <table width="300" align="center" border="1">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"  /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr align="center">
                <td></td>
                <td>
                    <input type="submit" value="登录" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
