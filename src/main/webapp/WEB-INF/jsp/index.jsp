<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>RojerAlone</title>
    <%--<script>--%>
        <%--$(document).ready(function () {--%>
            <%--$.get("/blog/hotblogs", function (data, status) {--%>
                <%--alert("data:" + data + ",status:" + status);--%>
            <%--});--%>
        <%--});--%>
    <%--</script>--%>
</head>
<body>
    <jsp:include page="common/top.jsp" />
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="common/leftpanel.jsp" />
            <div class="col-lg-6">
                <%--滚动播放--%>
                <div class="container-fluid">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="/img/one.jpg" alt="One" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3>Los Angeles</h3>
                                    <p>LA is always so much fun!</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="/img/two.jpg" alt="Two" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3>Chicago</h3>
                                    <p>Thank you, Chicago!</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="/img/three.jpg" alt="Three" style="width:100%;">
                                <div class="carousel-caption">
                                    <h3>New York</h3>
                                    <p>We love the Big Apple!</p>
                                </div>
                            </div>
                        </div>
                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="latest-article">
                    <h2><span class="label label-info">最新文章</span></h2>
                </div>
                    <div class="row">
                        <c:forEach items="${firstPage}" var="blog">
                            <div class="article-panel">
                                <a href="/blog/${blog.blog.bid}" class="article-title">
                                    <h4>
                                        <c:if test="${blog.blog.up == 1}">
                                            <font color="red">[置顶]</font>
                                        </c:if>
                                        ${blog.blog.title}
                                    </h4>
                                </a>
                                <div class="article-info">
                                    <span class="article-info-tag">
                                        <span class="glyphicon glyphicon-time"></span>
                                        <fmt:formatDate value="${blog.blog.ctime}" type="both" pattern="yyyy-MM-dd HH:mm" />
                                    </span>
                                    <span class="article-info-tag">
                                        <span class="glyphicon glyphicon-user"></span>
                                        ${blog.username}
                                    </span>
                                    <span class="article-info-tag">
                                        <span class="glyphicon glyphicon-eye-open"></span>
                                        浏览(${blog.blog.clicked})
                                    </span>
                                    <span class="article-info-tag">
                                        <span class="glyphicon glyphicon-comment"></span>
                                        评论(${blog.blog.comments})
                                    </span>
                                    <%--<c:if test="${sessionScope.containsKey(user)}">--%>
                                        <a href="/blog/delete/" class="article-info-manager">删除</a>
                                        <a href="/blog/edit?bid=${blog.blog.bid}" class="article-info-manager">编辑</a>
                                    <%--</c:if>--%>
                                </div>
                                <div class="article-content">
                                    ${blog.blog.content}
                                </div>

                            </div>
                        </c:forEach>
                    </div>
            </div>
            <div class="col-lg-2"></div>
        </div>
    </div>
    <jsp:include page="common/bottom.jsp" />
    <%--<script>--%>
        <%--${document}.ready(function () {--%>
            <%--$.get("/blog/hotblogs", function (data, status) {--%>
                <%--alert("data:" + data + ",status:" + status);--%>
            <%--});--%>
<%--//            $.ajax({--%>
<%--//                url: "/blog/hotblogs",--%>
<%--//                dataType: "JSON",--%>
<%--//                type: "GET",--%>
<%--//                cache: false,--%>
<%--//                success: function (result) {--%>
<%--//                    result.[]--%>
<%--//                }--%>
<%--//            });--%>
        <%--});--%>
    <%--</script>--%>
</body>
</html>
