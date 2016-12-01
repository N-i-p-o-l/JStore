<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
  <h2>Your cart</h2>

    <table class="table table-hover">
      <tr>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
      </tr>
      <c:forEach var="product" items="${cart.contents}">
        <tr>
          <td>${product.key.name}</td>
          <td>${product.value}</td>
          <td>${product.key.price * product.value}</td>
        </tr>
      </c:forEach>

      <tr></tr>
      <tr>
        <td>Total</td>
        <td></td>
        <td>$${cart.totalCost}</td>
      </tr>
    </table>

</div>

