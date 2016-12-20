var app = angular.module('customer', []);

app.factory('customerFactory', function () {
  var data = [];
  return {
    fetchData: function () {
      return data;
    },
    pull: function () {
      data = customers;
    },
    remove: function (index) {
      data.splice(index, 1);
    },
    add: function(item) {
      data.push(item);
    }
  }
});

app.controller('customerController', function ($scope, $http, customerFactory) {
  var self = this;
  
  customerFactory.pull();
  $scope.data = customerFactory.fetchData();

  self.removeCustomer = function (item) {
    var index = $scope.data.indexOf(item);
    var customer = $scope.data[index];
    customerFactory.remove(index);
    $http({
      method: 'GET',
      url: '/customer/remove?id=' + customer.id
    }).then(function successCallback(response) {
    }, function errorCallback(response) {
         customerFactory.add(customer);
    });
  }

});