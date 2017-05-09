<%--
  User: Alone
  Date: 2017/4/8
  Time: 17:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <c:if test="${info} != null">
        <h1>${info}</h1>
    </c:if>
    <form action="/user/register" method="post">
        <table width="300" align="center" border="1">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>昵称：</td>
                <td><input type="text" name="nickname" /></td>
            </tr>
            <tr>
                <td>Email：</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td>电话号码：</td>
                <td><input type="text" name="phone" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="注册" align="center"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
