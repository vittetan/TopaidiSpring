<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

	<spring:url value="" var="processUrl"/>
	<form:form method="post" action="" modelAttribute="idea">
		
		<form:input path="brain.id" type="hidden"/>
		
		<div class="form-group">			
			<form:label path="title">Title</form:label>
			<form:input path="title" class="form-control"/>
		</div>
		
		<div class="form-group">		
			<form:label path="description">Description</form:label>
			<form:input path="description" class="form-control" />
		</div>
				
		<div class="form-group">
			<label for=category>Category</label>
			<form:select path="category.name" items="${categories}" itemlabel="category.name" itemValue="id" class="form-control"/>
		</div>
				
		<button class="btn btn-success" type="submit">New Idea</button>
	</form:form>


</body>
</html>