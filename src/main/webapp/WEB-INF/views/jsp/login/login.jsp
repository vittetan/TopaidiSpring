<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>Welcome back !</h1><br/>
<p>${sessionScope.connected}</p>
<p>${sessionScope.pers}</p>

<spring:url value="/login/processForm" var="processUrl"/>
<c:if test="${action == 'failed'}">
	<div class="alert alert-danger" role="alert">
  		Login/password doesn't exist !
	</div>
</c:if>

	<form:form class="form-group" method="post" action="${processUrl}" modelAttribute="pers">
		<div class="form-group">
			<form:label path="login">Login</form:label>
			<form:input class="form-control" path="login" />
		</div>
		
		<div class="form-group">
			<form:label path="password">Password</form:label>
			<form:input type="password" class="form-control" path="password" />
		</div>
		<button class="btn btn-success" type="submit">Connect</button>
	</form:form>

</div>
</body>
</html>