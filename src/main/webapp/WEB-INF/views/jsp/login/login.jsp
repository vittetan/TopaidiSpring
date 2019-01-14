<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>Welcome back !</h1><br/>
<p>${sessionScope.connected}</p>
<p>${sessionScope.pers}</p>

<spring:url value="/login/processForm" var="processUrl"/>

	<form:form method="post" action="${processUrl}" modelAttribute="pers">
		<form:input path="id" type="hidden"/>
		
		<spring:hasBindErrors name="pers">
			<c:set var="errorClass" value="border:1px solid red;"></c:set> 
		</spring:hasBindErrors>
		<form:label path="login">Login</form:label>
		<form:input path="login" />
		<form:errors path="login" type="text" style="${errorClass}"/>
		
		<form:label path="password">Last name</form:label>
		<form:input path="password" />
		
		<input type="submit" value="Connect">
	</form:form>

</div>
</body>
</html>