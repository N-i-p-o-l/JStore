<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
  <a href=" <c:url value="/catalog/add"/>" />Add catalog</a>
</div>

<table class="table table-hover">
  <thead>
  <tr>
    <th>Name</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="catalog" items="${catalogs}">
    <tr>
      <td>
        <a href="<c:url value="/catalog/${catalog.id}"/>">${catalog.name}</a>
      </td>
      <td>
        <a href="<c:url value="/catalog/edit?id=${catalog.id}"/>" class="btn btn-success">
            <span class="glyphicon glyphicon-pencil"></span>
        </a>
        <a href="<c:url value="/catalog/remove?id=${catalog.id}"/>" class="btn btn-danger">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
