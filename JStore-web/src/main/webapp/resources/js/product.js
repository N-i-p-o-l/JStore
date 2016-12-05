var app = angular.module('product-rest', []);

app.controller('product-ctrl', function ($scope, $http) {
  $http.get("/api/v1/product/2")
      .then(function (response) {
        $scope.data = response.data;
      })
});