<%--
  User: RojerAlone
  Date: 2017/5/19
  Time: 17:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="taglib.jsp"%>
<%--左侧信息栏--%>
<div class="col-lg-4">
    <div class="row">
        <div class="col-lg-6"></div>
        <div class="col-lg-6">
            <img class="img-head img-responsive img-rounded" src="/img/head.jpg">
            <%--个人简介--%>
            <div class="row">
                <center>
                    <h3>RojerAlone</h3>
                    <h4>Java Coder</h4>
                    <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> Shaanxi,China
                </center>
            </div>
            <%--Follow me--%>
            <div class="row">
                <h4><span class="label label-info">关注我</span></h4>
                <div class="col-lg-3">
                    <a href="https://github.com/RojerAlone" target="_blank">
                        <img src="/img/github.png" class="img-rounded img-responsive">
                    </a>
                </div>
                <div class="col-lg-3">
                    <a href="http://blog.csdn.net/alone_rojer" target="_blank">
                        <img src="/img/csdn.png" class="img-rounded img-responsive">
                    </a>
                </div>
                <div class="col-lg-3">
                    <a href="http://www.weibo.com/u/5192122666" target="_blank">
                        <img src="/img/weibo.png" class="img-rounded img-responsive">
                    </a>
                </div>
                <div class="col-lg-3">
                    <a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=1091165843" target="_blank">
                        <img src="/img/qq.png" class="img-rounded img-responsive">
                    </a>
                </div>
            </div>
            <%--文章类别，有分类时才显示--%>
            <c:if test="${not empty kinds}">
                <div class="row">
                    <h4><span class="label label-info">文章分类</span></h4>
                    <ul class="list-group">
                        <c:forEach items="${kinds}" var="kind">
                            <a href="/kind/${kind.kid.intValue()}" class="list-group-item">
                                <div class="left-panel-name">${kind.name}</div>
                                <span class="badge badge-info">${kind.nums}</span>
                            </a>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <%--点击量前五的文章--%>
            <c:if test="${not empty hotBlogs}">
                <div class="row">
                    <h4><span class="label label-info">热门文章</span></h4>
                    <ul class="list-group">
                        <c:forEach items="${hotBlogs}" var="blog">
                            <a href="/blog/${blog.blog.bid}" class="list-group-item">
                                <div class="left-panel-name">${blog.blog.title}</div>
                                <span class="badge badge-info">${blog.blog.clicked}</span>
                            </a>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</div>
