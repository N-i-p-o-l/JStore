<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true" />
  </c:set>
  <title><spring:message code="${titleKey}"/></title>
  <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>

<div class="container">

  <div class="header">

    <h3 class="text-muted">JStore</h3>

    <security:authorize access="isAuthenticated()">
      <h1>You are logged</h1>
    </security:authorize>

    <ul class="nav nav-pills pull-right">
      <tiles:insertAttribute name="header" />
    </ul>

  </div>

  <div class="row">
    <tiles:insertAttribute name="body" />
  </div>

  <div class="footer">
    <tiles:insertAttribute name="footer" />
  </div>

</div>

</body>
</html>