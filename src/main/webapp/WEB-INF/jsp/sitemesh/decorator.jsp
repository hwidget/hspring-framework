<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/27
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <sitemesh:write property='title'/> - ltcms
    </title>
    <sitemesh:write property='head'/>
</head>
<body>
    <header>header</header>
    <hr/>

    demo.html的title将被填充到这儿：

    <sitemesh:write property='title'/><br/>

    demo.html的body将被填充到这儿：

    <sitemesh:write property='body'/>

    <hr/>
    <footer>footer</footer>
</body>
</html>


