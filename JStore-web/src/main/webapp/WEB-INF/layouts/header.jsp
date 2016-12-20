<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<li><a href="<spring:url value="/"/>">Home</a></li>
<li><a href="<spring:url value="/catalog"/>">Catalogs</a></li>
<li><a href="<spring:url value="/cart"/>">Cart</a></li>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/customer/all"/>">Users</a></li>
</sec:authorize>

<li><a href="<spring:url value="#"/>">About</a></li>
