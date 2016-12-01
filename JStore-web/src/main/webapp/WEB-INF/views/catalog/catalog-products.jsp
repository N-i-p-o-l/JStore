<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<div>
  <a href=" <c:url value="/product/add?id=${catalog_id}"/>" >Add Product</a>
</div>
</sec:authorize>

<table class="table table-hover">
  <thead>
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>Action</th>
    <th>Image</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}">
      <td> ${product.name} </td>
      <td> ${product.description} </td>

      <sec:authorize access="hasRole('ROLE_ADMIN')">
      <td>
        <a href="<c:url value="/product/edit?id=${product.id}"/>" class="btn btn-success">
          <span class="glyphicon glyphicon-pencil"></span>
        </a>
        <a href="<c:url value="/product/remove?id=${product.id}"/>" class="btn btn-danger">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
      </td>
      </sec:authorize>

      <sec:authorize access="!hasRole('ROLE_ADMIN')">
        <td>Actions not allowed</td>
      </sec:authorize>

      <td>
        <img src=" <c:url value="/resources/images/${product.id}.png"/> " alt="image" style="width:10%">
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
