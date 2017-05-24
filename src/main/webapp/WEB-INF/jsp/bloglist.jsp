<%--
  User: Alone
  Date: 2017/4/11
  Time: 21:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <jsp:include page="common/head.jsp" />
    <title>所有文章</title>
</head>
<body>
<jsp:include page="common/top.jsp" />

<div class="row">
    <%--左侧信息栏--%>
    <jsp:include page="common/leftpanel.jsp"/>
    <div class="col-lg-6">
        <%@ include file="common/articlelist.jsp"%>
        <row>
            <nav aria-label="Page navigation">
                <ul class="pager">
                    <%--<div style="margin-left: 0px;">--%>
                    <%--共 ${page.pages} 页，当前第 ${page.current} 页--%>
                    <%--</div>--%>
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
                    <c:choose>
                        <%--如果当前页数是3页以后，就要--%>
                        <c:when test="${page.current > 3}">
                            <c:forEach var="p" begin="${page.current - 2}"
                                       end="${page.current + 2 < page.pages ? page.current + 2 : page.pages}">
                                <li><a href="/blog/all/${p}">${p}</a></li>
                            </c:forEach>
                        </c:when>
                        <%--如果当前页数是前3页，直接显示前5页--%>
                        <c:otherwise>
                            <c:forEach var="p" begin="1" end="${page.pages < 5 ? page.pages : 5}">
                                <li><a href="/blog/all/${p}">${p}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    <li>
                        <c:choose>
                            <c:when test="${page.current < page.pages}">
                                <a href="/blog/all/${page.current + 1}" aria-label="Previous">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:when>
                            <c:otherwise>
                                <a href="/blog/all/${page.current}" aria-label="Previous">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                    <li><a href="/blog/all/${page.pages}">尾页</a></li>
                </ul>
            </nav>
        </row>
    </div>
    <div class="col-lg-2"></div>
</div>
</div>
<jsp:include page="common/bottom.jsp" />
</body>
</html>
