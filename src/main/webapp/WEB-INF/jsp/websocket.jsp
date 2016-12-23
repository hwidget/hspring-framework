<%@page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <title>websocket 数据推送测试</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script type="text/javascript" src="${basePath}/resources/sockjs/sockjs-0.3.4.min.js"></script>

    <script type="text/javascript">
        (function(){
            var url = "${pageContext.servletContext.contextPath}/aaa";
            var sock = new SockJS(url);
            sock.onopen = function () {
                console.log('open');
                //sock.send("auth:");
            };
            sock.onmessage = function (e) {
                var data = e.data;
                console.log(data)
            };
            sock.onclose = function () {
                console.log('close');
            };
        })();
    </script>
</head>
<body >
    <h1>Web Socket 数据推送到页面</h1>


</body>
</html>

