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
            <%--左侧信息栏--%>
            <div class="col-lg-4">
                <div class="row">
                    <div class="col-lg-6"></div>
                    <div class="col-lg-6">
                        <img class="img-responsive" src="/img/head.jpg">
                        <div class="row">
                            <p class="text-center">
                                个人简介
                            </p>
                        </div>
                        <%--文章类别，有分类时才显示--%>
                        <c:if test="${not empty kinds}">
                            <div class="row">
                                <h4><span class="label label-info">文章分类</span></h4>
                                <ul class="list-group">
                                    <c:forEach items="${kinds}" var="kind">
                                        <a href="/kind/${kind.kid.intValue()}" class="list-group-item text-overflow">
                                            ${kind.name}<span class="badge badge-info">${kind.nums}</span>
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
                                            ${blog.blog.title}<span class="badge badge-info">${blog.blog.clicked}</span>
                                        </a>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
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
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
                <p>一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release() 添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore 只对可用许可的号码进行计数，并采取相应的行动。 </p>
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
