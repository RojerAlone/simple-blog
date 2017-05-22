<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
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
<jsp:include page="common/top.jsp"/>
<div class="container-fluid">
    <div class="row">
        <jsp:include page="common/leftpanel.jsp"/>
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
                                        <fmt:formatDate value="${blog.blog.ctime}" type="both"
                                                        pattern="yyyy-MM-dd HH:mm"/>
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
                            <a href="/blog/delete?bid=${blog.blog.bid}" class="article-info-manager">删除</a>
                            <a href="/blog/edit?bid=${blog.blog.bid}" class="article-info-manager"
                               methods="delete">编辑</a>
                                <%--</c:if>--%>
                        </div>
                            <%--<div id="layout">--%>
                            <%--<div id="blog-content">&lt;%&ndash;  class="article-content" &ndash;%&gt;--%>
                            <%--<textarea id="append-test" style="display:none;">${blog.blog.content}</textarea>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                        <div class="article-content" class="article-content">
                                ${blog.blog.content.substring(0, blog.blog.content.length() > 200 ? 200 : blog.blog.content.length())}
                        </div>
                    </div>
                </c:forEach>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>共 ${page.pages} 页，当前第 ${page.current} 页</li>
                    <li><a href="/blog/all/1">首页</a></li>
                    <li>
                        <c:choose>
                            <c:when test="${page.current == 1}">
                                <a href="/blog/all/1" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="/blog/all/${page.current - 1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li><a href="/blog/all/1">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <li><a href="/blog/all/${page.pages}">尾页</a></li>
                </ul>
            </nav>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>

<jsp:include page="common/bottom.jsp"/>

<script src="/lib/marked.min.js"></script>
<script src="/lib/prettify.min.js"></script>

<script src="/lib/raphael.min.js"></script>
<script src="/lib/underscore.min.js"></script>
<script src="/lib/sequence-diagram.min.js"></script>
<script src="/lib/flowchart.min.js"></script>
<script src="/lib/jquery.flowchart.min.js"></script>
<script src="/js/editormd.js"></script>
<script>
    $(function () {
        var editormdView;
        editormdView = editormd.markdownToHTML("blog-content", {
            htmlDecode: "style,script,iframe",  // you can filter tags decode
            emoji: true,
            taskList: true,
            tex: true,  // 默认不解析
            flowChart: true,  // 默认不解析
            sequenceDiagram: true,  // 默认不解析
        });
//            alert("1");
//            var content = document.getElementById("article-content");
//            alert(editormdView.innerText.substr(0, 100));
//            alert(editormdView.getElementById("layout").innerText.substr(0, 100));
//            content.innerText = editormdView.getElementById("layout").innerText.substr(0, 100);
//            alert("3");
//            content.innerText = "这是内容";
    });
    alert("zhongjian")
    <%--${document}.ready(function () {--%>
    function content() {
        alert("ready")
        var content = document.getElementsByClassName("article-content");
        content.innerText = "这是内容";
    }
    content();
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
    })
    ;
</script>
</body>
</html>
