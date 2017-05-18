<%--
  User: RojerAlone
  Date: 2017/5/16
  Time: 22:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述三个标签需要放到最前边 -->
    <meta name="description" content="RojerAlone的个人网站">
    <meta name="author" content="RojerAlone">
    <link rel="icon" href="/smile.ico" type="image/x-icon" >
    <!-- 引入 Bootstrap的css文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link href="/css/scrollup.css" rel="stylesheet">
    <link id="scrollUpTheme" rel="stylesheet" href="/css/scrollup.css">

    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/editormd-style.css"/>
    <link rel="stylesheet" href="/css/editormd.css"/>
</head>
<body>
    <div id="layout">
        <header>
            <h1>Simple example</h1>
        </header>
        <div id="test-editormd">
            <textarea style="display:none;">
            </textarea>
        </div>
    </div>
    <script src="/js/editormd.min.js" charset="UTF-8"></script>
    <script type="text/javascript">
        var testEditor;
        $(function () {
            testEditor = editormd("test-editormd", {
                width: "90%",
                height: 800,
                syncScrolling: "single",
                path: "/lib/"
            });

            /*
             // or
             testEditor = editormd({
             id      : "test-editormd",
             width   : "90%",
             height  : 640,
             path    : "../lib/"
             });
             */
        });
    </script>
</body>
</html>