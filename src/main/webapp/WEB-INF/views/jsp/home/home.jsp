<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topaidi</title>
</head>
<body>
<div class="container">

<h1>Welcome to Topaidi. we are the best!</h1><br/>

	<form:form method="post" modelAttribute="admin">
				
		<form:label path="login">Login</form:label>
		<form:input path="login" />
		
		<form:label path="password">Password</form:label>
		<form:input path="password" />
		
		<input type="submit" value="Sign in">
	</form:form>
	
	<a href="home/newBrain"><button type="button" class="btn btn-success btn-xs">Become a new brain</button></a>	
			

</div>
</body>
</html>