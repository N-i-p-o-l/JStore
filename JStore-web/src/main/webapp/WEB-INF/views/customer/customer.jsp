<%@ taglib prefix="ju" uri="/WEB-INF/tld/json.tld"%>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/customer.js"></script>

<script>
  var customers = ${ju:toJson(customers)};
</script>

<div ng-app="customer" ng-controller="customerController">
<table class="table table-hover">
  <thead>
  <tr>
    <th>Login</th>
    <th>Email</th>
  </tr>
  </thead>
  <tbody>
    <tr ng-repeat="customer in data">
      <td>{{customer.login}}</td>
      <td>{{customer.email}}</td>
    </tr>
  </tbody>
</table>
</div>