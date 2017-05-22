<%--
  User: Alone
  Date: 2017/4/9
  Time: 22:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="common/taglib.jsp" %>
<html>
<head>
    <%--<jsp:include page="common/head.jsp" />--%>
    <%@ include file="common/head.jsp"%>
    <title>${blog.blog.title}</title>
    <%--<link rel="stylesheet" href="/css/editormd-style.css" charset="UTF-8"/>--%>
    <link rel="stylesheet" href="/css/editormd.css" charset="UTF-8"/>
    <%--<link rel="stylesheet" href="/css/style.css" />--%>
    <link rel="stylesheet" href="/css/editormd.preview.css" />
    <link rel="icon" href="/smile.ico" type="image/x-icon" >
    <style>
        .editormd-html-preview {
            width: 100%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<jsp:include page="common/top.jsp" />
<div class="container-fluid">
    <div class="row">
        <%@ include file="common/leftpanel.jsp"%>
        <div class="col-lg-6">
            <div id="layout">
                <h2 style="margin-left: 15px;">${blog.blog.title}</h2>
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
                    <a href="/blog/delete?bid=${blog.blog.bid}" class="article-info-manager">删除</a>
                    <a href="/blog/edit?bid=${blog.blog.bid}" class="article-info-manager" methods="delete">编辑</a>
                    <%--</c:if>--%>
                </div>
                <div id="editormd-view">
                    <textarea id="append-test" style="display:none;">${blog.blog.content}</textarea>
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<jsp:include page="common/bottom.jsp" />

<!-- <script src="js/zepto.min.js"></script>
<script>
    var jQuery = Zepto;  // 为了避免修改flowChart.js和sequence-diagram.js的源码，所以使用Zepto.js时想支持flowChart/sequenceDiagram就得加上这一句
</script> -->
<%--<script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>--%>
<script src="/lib/marked.min.js"></script>
<script src="/lib/prettify.min.js"></script>

<script src="/lib/raphael.min.js"></script>
<script src="/lib/underscore.min.js"></script>
<script src="/lib/sequence-diagram.min.js"></script>
<script src="/lib/flowchart.min.js"></script>
<script src="/lib/jquery.flowchart.min.js"></script>

<script src="/js/editormd.js"></script>
<script type="text/javascript">
    $(function() {
        var editormdView;

        <%--$.get("test.md", function(markdown) {--%>
            <%--function t () {--%>
                <%--testEditormdView = editormd.markdownToHTML("test-editormd-view", {--%>
                    <%--markdown        : ${blog.blog.content} ,//+ "\r\n" + $("#append-test").text(),--%>
                    <%--//htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启--%>
                    <%--htmlDecode      : "style,script,iframe",  // you can filter tags decode--%>
                    <%--//toc             : false,--%>
                    <%--tocm            : true,    // Using [TOCM]--%>
                    <%--//tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层--%>
                    <%--//gfm             : false,--%>
                    <%--//tocDropdown     : true,--%>
                    <%--// markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签--%>
                    <%--emoji           : true,--%>
                    <%--taskList        : true,--%>
                    <%--tex             : true,  // 默认不解析--%>
                    <%--flowChart       : true,  // 默认不解析--%>
                    <%--sequenceDiagram : true,  // 默认不解析--%>
                <%--});--%>
            <%--};--%>
<%--//            t();--%>
            <%--//console.log("返回一个 jQuery 实例 =>", testEditormdView);--%>

            <%--// 获取Markdown源码--%>
            <%--//console.log(testEditormdView.getMarkdown());--%>

            <%--//alert(testEditormdView.getMarkdown());--%>
        <%--});--%>
        editormdView = editormd.markdownToHTML("editormd-view", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
            atLink          : false, // 不解析@为链接
        });
    });
</script>
</body>
</html>