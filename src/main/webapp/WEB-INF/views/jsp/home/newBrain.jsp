<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>We are ready to welcome a new great artist!</h1><br/>

<spring:url value="/artists/processForm" var="processUrl"/>

	<form:form method="post" action="${processUrl}" modelAttribute="art">
		<form:input path="id" type="hidden"/>
		
		<spring:hasBindErrors name="art">
			<c:set var="errorClass" value="border:1px solid red;"></c:set> 
		</spring:hasBindErrors>
		<form:label path="firstName">First name</form:label>
		<form:input path="firstName" />
		<form:errors path="firstName" type="text" style="${errorClass}"/>
		
		<form:label path="lastName">Last name</form:label>
		<form:input path="lastName" />
		
		<form:label path="stageName">Stage name</form:label>
		<form:input path="stageName" />
		
		<input type="submit" value="New artist">
	</form:form>

</div>
</body>
</html>