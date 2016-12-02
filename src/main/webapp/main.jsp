<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>跳转中..</title>
    <script src="${basePath}/resources/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        top.location.href = "${basePath}/admin/index.do?_"+new Date().getTime();
    </script>

<body>
    正在跳转....
</body>
</html>
