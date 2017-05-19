<%--
  User: Alone
  Date: 2017/4/9
  Time: 22:53
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%--<%@ include file="common/taglib.jsp" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<jsp:include page="common/head.jsp" />--%>
    <%--<title>${blog.blog.title}</title>--%>
    <%--<link rel="stylesheet" href="/css/editormd-style.css" charset="UTF-8"/>--%>
    <%--<link rel="stylesheet" href="/css/editormd.css" charset="UTF-8"/>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="common/top.jsp" />--%>
<%--<div class="container-fluid">--%>
    <%--<div class="row">--%>
        <%--<jsp:include page="common/leftpanel.jsp" />--%>
        <%--<div class="col-lg-6">--%>
            <%--<div class="markdown-body editormd-preview-container editormd-preview-active">--%>
                <%--${blog.blog.content}--%>
            <%--</div>--%>
            <%--&lt;%&ndash;<div class="article-content">${blog.blog.content}</div>&ndash;%&gt;--%>
        <%--</div>--%>
        <%--<div class="col-lg-2"></div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<jsp:include page="common/bottom.jsp" />--%>
<%--<script src="/js/editormd.min.js" charset="UTF-8"></script>--%>
<%--</body>--%>
<%--</html>--%>
<%--<!DOCTYPE html>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh">
<head>
    <meta charset="utf-8" />
    <title>HTML Preview(markdown to html) - Editor.md examples</title>
    <link rel="stylesheet" href="/css/style.css" />
    <link rel="stylesheet" href="/css/editormd.preview.css" />
    <link rel="icon" href="/smile.ico" type="image/x-icon" >
    <style>
        .editormd-html-preview {
            width: 90%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div id="layout">
    <header>
        <h1>Markdown转HTML的显示处理</h1>
        <p>即：非编辑情况下的HTML预览</p>
        <p>HTML Preview(markdown to html)</p>
    </header>
    <div id="test-editormd-view">
        <textarea style="display:none;" name="test-editormd-markdown-doc">${blog.blog.content}</textarea>
    </div>
    <div id="test-editormd-view2">
        <textarea id="append-test" style="display:none;">
            ${blog.blog.content}
        </textarea>
    </div>
</div>
<!-- <script src="js/zepto.min.js"></script>
<script>
    var jQuery = Zepto;  // 为了避免修改flowChart.js和sequence-diagram.js的源码，所以使用Zepto.js时想支持flowChart/sequenceDiagram就得加上这一句
</script> -->
<script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
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
        var testEditormdView, testEditormdView2;

//        $.get("test.md", function(markdown) {
            function t () {
                testEditormdView = editormd.markdownToHTML("test-editormd-view", {
                    markdown        : ${blog.blog.content} ,//+ "\r\n" + $("#append-test").text(),
                    //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                    htmlDecode      : "style,script,iframe",  // you can filter tags decode
                    //toc             : false,
                    tocm            : true,    // Using [TOCM]
                    //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
                    //gfm             : false,
                    //tocDropdown     : true,
                    // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                    emoji           : true,
                    taskList        : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,  // 默认不解析
                });
            };
            t();
            //console.log("返回一个 jQuery 实例 =>", testEditormdView);

            // 获取Markdown源码
            //console.log(testEditormdView.getMarkdown());

            //alert(testEditormdView.getMarkdown());
//        });

        testEditormdView2 = editormd.markdownToHTML("test-editormd-view2", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });
    });
</script>
</body>
</html>