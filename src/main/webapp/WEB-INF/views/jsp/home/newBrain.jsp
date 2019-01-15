<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>We are ready to welcome a new genius!</h1><br/>

<spring:url value="" var="processUrl"/>
<form:form method="POST" action="" modelAttribute="newBrain" >
	
	<div class="form-group">
	<spring:hasBindErrors name="newBrain">
		<c:set var="errorClass" value="font-family:verdana; font-weight:bold; font-style:italic; color:red; font-size:0.875em;"></c:set> 
	</spring:hasBindErrors>
	<form:label path="login">Login (valid email)</form:label>
	<form:input path="login" type="email" class="form-control"/>
	<form:errors path="login" type="text" style="${errorClass}"/>
	</div>
	
	<div class="form-group">			
	<form:label path="password">Password</form:label>
	<form:input path="password" type="password" class="form-control"/>
	<form:errors path="password" type="text" style="${errorClass}"/>
	</div>
	
	<div class="form-group">
	<form:label path="pseudo">Pseudo</form:label>
	<form:input path="pseudo" class="form-control"/>
	<form:errors path="pseudo" type="text" style="${errorClass}"/>
	</div>
		
	<button class="btn btn-success" type="submit">New Brain</button>
</form:form>

<div id="showWelcome" style ="visibility :hidden" >
	We have received your request. If all you data are OK you'll become a Brain in very short time. Congratulations! 
</div>

<button id="backHome" onclick="backhome()" style ="visibility :hidden">Back to Topaidi</button>
	
<script>

	function showWelcome(e){
		e.preventDefault();
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