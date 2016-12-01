<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <c:set var="titleKey">
    <tiles:insertAttribute name="title" ignore="true"/>
  </c:set>
  <title><spring:message code="${titleKey}"/></title>
  <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.js"></script>
</head>
<body>

<div class="container">

  <div class="header">

    <span><h2 class="text-muted">JStore </h2></span>

    <sec:authorize access="isAnonymous()">
      <div align="right">
        <a class="btn btn-primary" href="/login" role="button">Login</a>
        <a class="btn btn-primary" href="/customer/register" role="button">Sign Up</a>
      </div>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
      <sec:authentication var="user" property="principal"/>
      <div align="right">
        <span class="text-success">Hello ${user.username},</span>
        <a href="/logout">Logout</a>
      </div>
    </sec:authorize>

    <ul class="nav nav-pills pull-right">
      <tiles:insertAttribute name="header"/>
    </ul>

  </div>

  <div class="row" style="margin-top: 3%">
    <tiles:insertAttribute name="body"/>
  </div>

  <div class="footer" style="margin-top: 5%">
    <tiles:insertAttribute name="footer"/>
  </div>

</div>

</body>
</html>