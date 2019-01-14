<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<spring:url value="" var="processUrl"/>

	<form:form method="post" action="${processUrl}" modelAttribute="idea">
					
		<form:label path="title">Title</form:label>
		<form:input path="title" />
				
		<form:label path="description">Description</form:label>
		<form:input path="description" />
		
		<label for=cateogry>Category</label>
		<form:select path="category.id" items="${categories}" itemlabel="name" itemValue="id" class="form-control"/>
				
		<input type="submit" value="New Idea">
	</form:form>


</body>
</html>