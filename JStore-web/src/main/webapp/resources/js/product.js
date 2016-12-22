var app = angular.module('product-rest', []);

app.controller('product-ctrl', function ($scope, $http) {

  $scope.options = [
    { label: '50', value: 50 },
    { label: '100', value: 100 },
    { label: '200', value: 200 }
  ];

  $scope.getProductOverPrice = function() {
    $http.get("/api/product?price=" + $scope.price.value)
        .then(function (response) {
          $scope.data = response.data;
        });
  };

  $scope.price = $scope.options[0];
  $scope.getProductOverPrice();
});