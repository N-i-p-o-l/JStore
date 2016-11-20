<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="container">
  <form:form modelAttribute="catalog" class="form-horizontal">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <fieldset>
      <legend>Add new catalog</legend>

      <div class="form-group">
        <label class="control-label col-lg-2 col-lg-2" for="name">
          <spring:message code="catalog-add.form.name.label"/>
        </label>
        <div class="col-lg-10">
          <form:input path="name" type="text" class="form:input-large"/>
          <form:errors path="name" cssClass="text-danger"/>
        </div>
      </div>

      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
          <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
        </div>
      </div>

    </fieldset>
  </form:form>
</section>