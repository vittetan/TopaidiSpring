<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>We are ready to welcome a new genius!</h1><br/>

<spring:url value="" var="processUrl"/>
<form:form id="newBrain" method="post" action="" modelAttribute="newBrain" onsubmit="showWelcome();return false;">
	
	<form:label path="login">Login (valid email)</form:label>
	<form:input path="login"/>
				
	<form:label path="password">Password</form:label>
	<form:input path="password" />
	
	
	<form:label path="pseudo">Pseudo</form:label>
	<form:input path="pseudo" />
		
	<input type="submit" value="New Brain">
</form:form>

<div id="showWelcome" style ="visibility :hidden" >
	We have received your request. If all you data are OK you'll become a Brain in very short time. Congratulations! 
</div>

<button id="backHome" onclick="backhome()" style ="visibility :hidden">Back to Topaidi</button>
	
<script>

	function showWelcome(){
		document.getElementById("showWelcome").style.visibility = "visible";
		document.getElementById("backHome").style.visibility = "visible";
		return false;
	}
	
	function backhome(){
		location.replace("http://localhost:8080/topaidi/home");
	}
</script>
	
</div>
</body>
</html>