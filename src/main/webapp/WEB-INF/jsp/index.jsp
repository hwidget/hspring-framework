<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>测试文件上传</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${basePath}/resources/bootstrap/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${basePath}/resources/bootstrap/css/bootstrap-theme.min.css">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${basePath}/resources/jq/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${basePath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            background-color: #b0b5b8;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid" style="padding-left: 200px;padding-right: 200px;">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header" >
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="../../static/pic/logo.jpg" style="height: 30px;width: 70px;">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页<span class="sr-only">(current)</span></a></li>
                <li><a href="#">我的博客</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">博文分类<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Angular</a></li>
                        <li><a href="#">Javascript</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Hadoop</a></li>
                        <li><a href="#">HBase</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">D3.js</a></li>
                    </ul>
                </li>
                <li><a href="#">自我介绍</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </li>
                <li><p class="navbar-text">欢迎【<a href="#">Rayn</a>】登录</p></li>
                <li>
                    <button type="button" class="btn btn-default navbar-btn">Messages <span class="badge">4</span></button>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<!--  ======================================================================================================================================  -->
<div class="jumbotron" style="width:1200px;margin-left: auto;margin-right: auto;">
    <h1>自我介绍</h1>
    <p style="margin: 3px;">我是一个对理想有着执着追求的人，坚信是金子总会发光。大学毕业后的工作，让我在文案策划方面有了很大的提高，文笔流畅，熟悉传媒工作、广告学制作与设计等工作方面。为人热情，活泼，大方， 本人好学上进，诚信、敬业、责任心强，有强烈的团体精神，对工作认真积极，严谨负责。</p>
    <p style="margin-left:5px"><a class="btn btn-primary btn-lg" href="#" role="button">更多内容 >></a></p>
</div>






<h2>Hello World!</h2>

<form action="/test/upload.do" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="updateFile" id="updateFile"/><input type="submit" value="开始上传"/>
</form>

<div>
    <button type="button" class="btn btn-default">Default</button>
    <button type="button" class="btn btn-primary">Primary</button>
    <button type="button" class="btn btn-success">Success</button>
    <button type="button" class="btn btn-info">Info</button>
    <button type="button" class="btn btn-warning">Warning</button>
    <button type="button" class="btn btn-danger">Danger</button>
    <button type="button" class="btn btn-link">Link</button>

</div>

<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="true">
        Dropdown
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>


<div class="btn-group" role="group" aria-label="...">
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>

<div class="btn-toolbar" role="toolbar" aria-label="...">
    <div class="btn-group" role="group" aria-label="...">...</div>
    <div class="btn-group" role="group" aria-label="...">...</div>
    <div class="btn-group" role="group" aria-label="...">...</div>
</div>

<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
</ul>

<jsp:include page="../../bottom.jsp" />
</body>
</html>
