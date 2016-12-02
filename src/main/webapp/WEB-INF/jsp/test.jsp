<%@page language="java" contentType="text/html; charset=utf-8" %>
<html ng-app="test">
<head>
    <title>测试文件上传</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <jsp:include page="${basePath}/base.jsp"/>
    <script type="text/javascript" src="${basePath}/static/js/test.js"></script>
</head>
<body ng-controller="first">

<div style="width:1200px;margin-left: auto;margin-right: auto;">
    <h1>{{model.name}} 通讯录
        <span class="label label-default" ng-hide="incompleteCount() == 0" ng-class="warning()">共【{{incompleteCount()}}】</span>
    </h1>

    <div class="input-group" style="margin-bottom: 10px;">
        <input class="form-control" ng-model="addSchool"/>
            <span class="input-group-btn">
                <button class="btn btn-default" ng-click="addNewShool(addSchool)">新增学校</button>
            </span>
    </div>
    <button class="btn btn-danger">添加用户</button>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>学校名称({{model.school.length}})</th>
            <th>选中 ？</th>
            <th>当前状态（flase/true)</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="item in model.school | filter:{state:false} | orderBy : 'key'">
            <td>{{item}}</td>
            <td><input type="checkbox" ng-model="item.state"/></td>
            <td>{{item.state}}</td>
        </tr>
        </tbody>
        <tbody>
        <tr ng-repeat="item in model.school | checkItems:showComplete | orderBy : 'key'">
            <td>{{item}}</td>
            <td><input type="checkbox" ng-model="item.state"/></td>
            <td>{{item.state}}</td>
        </tr>
        </tbody>
    </table>
    <div class="checkbox-inline">
        <label><input type="checkbox" ng-model="showComplete"/>show complete ?</label></label>
    </div>
</div>


</body>
</html>
