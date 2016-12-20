<%@ taglib prefix="ju" uri="/WEB-INF/tld/json.tld"%>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/customer.js"></script>

<script>
  var customers = ${ju:toJson(customers)};
</script>

<div ng-app="customer" ng-controller="customerController as cstmCtrl">
<table class="table table-hover">
  <thead>
  <tr>
    <th>Login</th>
    <th>Email</th>
    <th>Role</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
    <tr ng-repeat="customer in data">
      <td>{{customer.login}}</td>
      <td>{{customer.email}}</td>
      <td>{{customer.role}}</td>
      <td><a class="btn btn-danger" ng-click="cstmCtrl.removeCustomer(customer)">Delete</a></td>
    </tr>
  </tbody>
</table>
</div>