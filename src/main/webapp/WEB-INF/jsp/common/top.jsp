<%--
  User: Alone
  Date: 2017/4/11
  Time: 14:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<div class="navbar navbar-static-top navbar-inverse" role="navigation">
    <div class="navbar-inner">
        <%--<div class="navbar-header">--%>
        <%--<a class="navbar-brand" href="/index">--%>
            <%--&lt;%&ndash;<img src="/IMAGE/title.jpg" class="img-responsive" width="30" height="50">&ndash;%&gt;--%>
            <%--<span class="site-title">RojerAlone</span>--%>
        <%--</a>--%>
        <%--</div>--%>
        <a href="/" class="navbar-brand"><img src="/img/title.jpg" alt="RojerAlone" style="height:45px;"></a>
        <ul class="nav navbar-nav">
            <li><a href="/index">首页</a></li>
            <li><a href="/blog/all">文章</a></li>
            <li><a href="/kind/all">类别</a></li>
            <li><a href="/about">关于我</a></li>
            <c:choose>
                <c:when test="${user == null}">
                    <li><a href="register" methods="get">注册</a></li>
                    <li><a href="login" methods="get">登录</a></li>
                </c:when>
                <c:otherwise>
                    <li>${user.nickname}</li>
                    <li><a href="/user/logout" methods="get">退出</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>

</div>
