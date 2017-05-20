<%--
  User: Alone
  Date: 2017/4/11
  Time: 14:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="taglib.jsp"%>
<nav class="navbar navbar-static-top navbar-inverse" role="navigation">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="/" class="navbar-brand">
                        <div class="row">
                            <div class="col-md-3">
                                <img src="/img/title.jpg" style="height:40px;position: relative;top: -10px;">
                            </div>
                            <div class="col-md-9">
                                <span class="site-title">RojerAlone</span>
                            </div>
                        </div>
                    </a>
                </div>
                <ul class="nav navbar-nav navbar-center">
                    <li><a href="/index">首页</a></li>
                    <li><a href="/blog/all">文章</a></li>
                    <li><a href="/kind/all">类别</a></li>
                    <li><a href="/about">关于我</a></li>
                    <c:choose>
                        <c:when test="${user == null}">
                            <li><a href="/register" methods="get">注册</a></li>
                            <li><a href="/login" methods="get">登录</a></li>
                        </c:when>
                        <c:otherwise>
                            <li>${user.nickname}</li>
                            <li><a href="/user/logout" methods="get">退出</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</nav>
