<%--
  User: RojerAlone
  Date: 2017/5/8
  Time: 21:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<footer class="footer" text-align="center">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<div class="col-lg-6"></div>--%>
            <%--<div class="col-lg-6">--%>
                <%--<p>Copyright © 2017 RojerAlone</p>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</footer>--%>
<div id="footer">
    <%--<div class="navbar navbar-fixed-bottom">--%>
        <div class="container">
            <p class="text-center muted-credit">Copyright © 2017 RojerAlone</p>
        </div>
    <%--</div>--%>
</div>
<%--<footer class="footer" style="margin-bottom: 30px;">--%>
    <%--<div class="container">--%>
        <%--<p class="text-center">Copyright © 2017 RojerAlone</p>--%>
    <%--</div>--%>
<%--</footer>--%>
<div class="scroll-bar pull-right">
    <%--http://www.w3cdream.com/content-sort-7-article-206.html  返回顶部插件--%>
    <a id="scrollUp" href="#top" class="back-to-top"></a>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script>
    $(window).bind('scroll', function () {
        var len = $(this).scrollTop();
        if (len <= 100) {
            $("#scrollUp").hide();
        } else {
            $("#scrollUp").show();
        }
    });

    $('body').css({
        "overflow-x":"hidden"
    });
</script>