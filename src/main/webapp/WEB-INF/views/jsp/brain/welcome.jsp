<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>
<spring:url value="/brain/${brainId}/newIdea" var="newIdeaUrl"/>
<h1>WELCOME BRAIN</h1>	

<br /> 
	<a href="${newIdeaUrl}" class="btn btn-success btn-xs">Let's share a new idea</a>
	
<br /> 
	<a href="/topaidi/home" class="btn btn-success btn-xs">Sign out</a>
	
		

</div>
</body>
</html>