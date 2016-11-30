<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="container">
  <legend>Register</legend>

  <spring:url value="/customer/register" var="actionUrl" />
  <form:form modelAttribute="customer" method="post"
             class="form-horizontal" action="${actionUrl}">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <fieldset>
      <form:hidden path="id" />

      <spring:bind path="login">
        <div class="form-group">
          <label class="control-label col-lg-2 col-lg-2" for="login">
            Login
          </label>
          <div class="col-lg-10">
            <form:input path="login" type="text" class="form:input-large" placeholder="Login"/>
            <form:errors path="login" cssClass="text-danger"/>
          </div>
        </div>
      </spring:bind>

      <spring:bind path="password">
        <div class="form-group">
          <label class="control-label col-lg-2 col-lg-2" for="password">
            Password
          </label>
          <div class="col-lg-10">
            <form:input path="password" type="text" class="form:input-large" placeholder="Password"/>
            <form:errors path="password" cssClass="text-danger"/>
          </div>
        </div>
      </spring:bind>

      <spring:bind path="email">
        <div class="form-group">
          <label class="control-label col-lg-2 col-lg-2" for="email">
            Email
          </label>
          <div class="col-lg-10">
            <form:input path="email" type="text" class="form:input-large" placeholder="email"/>
            <form:errors path="email" cssClass="text-danger"/>
          </div>
        </div>
      </spring:bind>

      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-10">
          <input type="submit" id="btnAdd" class="btn btn-primary" value ="Register"/>
        </div>
      </div>

    </fieldset>
  </form:form>

</section>