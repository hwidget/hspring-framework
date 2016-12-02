<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Spring MVC 管理系统</title>
    <jsp:include page="base.jsp"/>

    <style type="text/css">
        body {
            margin-top: 0px;
            margin-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            margin: 200px auto;
            max-width: 350px;
            padding: 30px;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin-heading{
            font-size: 50px;
        }


        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .background-img {
            position: absolute;
            width: 100%;
            height: 100%;
            z-index: -1
        }
    </style>
</head>
<body>
<div class="background-img">
    <img src="${basePath}/static/pic/login-back.jpg" height="100%" width="100%"/>
</div>

<div class="container">

    <form class="form-signin">
        <h1 class="form-signin-heading">系统登录</h1>
        <label for="inputEmail" class="sr-only">登录邮箱</label>
        登录邮箱<input type="email" id="inputEmail" class="form-control" placeholder="登录邮箱地址" required autofocus>
        <label for="inputPassword" class="sr-only">登录密码</label>
        登录密码<input type="password" id="inputPassword" class="form-control" placeholder="登录密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me">记住我
            </label>
            <label>
                <p><a href="#">忘记密码？</a></p>
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">点击登录</button>
    </form>

</div> <!-- /container -->


</body>
</html>
