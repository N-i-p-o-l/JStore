<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
  <a href=" <c:url value="/product/add?id=${id}"/>" />Add Product</a>
</div>

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
    <tr>
      <td>
        <a href="<c:url value="/product/${product.id}"/>">${product.name}</a>
      </td>
      <td> ${product.description} </td>
      <td>
        <a href="<c:url value="/product/edit?id=${product.id}"/>" class="btn btn-success">
          <span class="glyphicon glyphicon-pencil"></span>
        </a>
        <a href="<c:url value="/product/remove?id=${product.id}"/>" class="btn btn-danger">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
      </td>
      <td>
        <img src=" <c:url value="/resources/images/${product.id}.png"/> " alt="image" style="width:10%">
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
