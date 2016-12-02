var model = {
    name: "Ryan",
    age: 10,
    school: [{
        key: "first",
        name: "fffff",
        state: false
    }, {
        key: "seconds",
        name: "sss",
        state: false
    }, {
        key: "thrid",
        name: "ttt",
        state: false
    }]
};

var test = angular.module("test", []);

/**
 * 创建自定义过滤器(名称叫：checkItems)
 */
test.filter("checkItems", function () {
    return function (items, showComplete) {
        var resultArr = [];

        angular.forEach(items, function (item) {
            if (item.state == false || showComplete == true) {
                resultArr.push(item);
            }
        });
        return resultArr;
    }
});

/**
 * Ajax 获取数据
 */
test.run(function($http){
   $http.get("/admin/json.do").success(function(data){
       model.school.push(data.data)
   }).error(function(e){
       alert(e);
   });
});

test.controller("first", function ($scope) {
    $scope.model = model;
    $scope.incompleteCount = function () {
        var count = 0;
        angular.forEach($scope.model.school, function (schools) {
            if (schools.state) {
                count++;
            }
        });
        return count;
    };


    $scope.warning = function () {
        return $scope.incompleteCount() < 2 ? "label-success" : "label-warning";
    };

    /**
     * 新增Shool
     * @param school
     */
    $scope.addNewShool = function (school) {
        $scope.model.school.push({key: school, name: "test", state: false})
    }


});