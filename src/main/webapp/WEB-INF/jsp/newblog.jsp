<%--
  User: RojerAlone
  Date: 2017/4/12
  Time: 20:19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <title>编辑文章</title>
</head>
<body>

    <c:choose>
        <c:when test="${blog == null}">
            <form action="/blog/write" method="post">
                <input type="submit" value="发表文章" />
            </form>
        </c:when>
        <c:otherwise>
            <form action="/blog/update" method="post">
                <input type="submit" value="保存文章" />
            </form>
        </c:otherwise>
    </c:choose>
</body>
</html>
