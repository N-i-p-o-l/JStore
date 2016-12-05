<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/product.js"></script>

<div class="container" ng-app="product-rest" ng-controller="product-ctrl">
  <h2>Products</h2>

  <table class="table table-hover">
    <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Price</th>
    </tr>

    <tr ng-repeat="product in data">
      <td>{{product.name}}</td>
      <td>{{product.description}}</td>
      <td>{{product.price}}</td>
    </tr>

  </table>

</div>
