var app = angular.module('customer', []);

app.factory('customerFactory', function () {
  var data = [];
  return {
    fetchData: function () {
      return data;
    },
    pull: function () {
      data = customers;
    }
  }
});

app.controller('customerController', function ($scope, customerFactory) {
  customerFactory.pull();
  $scope.data = customerFactory.fetchData();
});