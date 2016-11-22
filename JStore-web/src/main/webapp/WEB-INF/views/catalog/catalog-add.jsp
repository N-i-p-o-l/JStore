<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="container">

  <c:choose>
    <c:when test="${catalog.id eq null}">
      <legend>Add new catalog</legend>
    </c:when>
    <c:otherwise>
      <legend>Edit catalog</legend>
    </c:otherwise>
  </c:choose>

  <spring:url value="/catalog/add" var="actionUrl" />
  <form:form modelAttribute="catalog" method="post"
             class="form-horizontal" action="${actionUrl}">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <fieldset>
      <form:hidden path="id" />

      <spring:bind path="name">
        <div class="form-group">
          <label class="control-label col-lg-2 col-lg-2" for="name">
            <spring:message code="catalog-add.form.name.label"/>
          </label>
          <div class="col-lg-10">
            <form:input path="name" type="text" class="form:input-large" placeholder="Name"/>
            <form:errors path="name" cssClass="text-danger"/>
          </div>
        </div>
      </spring:bind>

      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">

          <c:choose>
            <c:when test="${catalog.id eq null}">
              <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
            </c:when>
            <c:otherwise>
              <input type="submit" id="btnAdd" class="btn btn-primary" value ="Save"/>
            </c:otherwise>
          </c:choose>

        </div>
      </div>

    </fieldset>
  </form:form>
</section>