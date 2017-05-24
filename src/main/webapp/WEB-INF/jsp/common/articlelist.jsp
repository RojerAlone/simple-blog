<%--
  User: RojerAlone
  Date: 2017/5/24
  Time: 20:05
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--通用文章列表--%>
<div class="row">
    <c:forEach items="${blogs}" var="blog">
        <div class="article-panel">
            <a href="/blog/${blog.blog.bid}" class="article-title">
                <h4>${blog.blog.title}</h4>
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
            <div class="article-content" class="article-content">
                    ${blog.blog.content.substring(0, blog.blog.content.length() > 200 ? 200 : blog.blog.content.length())}
            </div>
        </div>
    </c:forEach>
</div>