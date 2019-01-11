<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>Welcome to Topaidi. We are the best!</h1><br/>

		
	<a href="newBrain"><button type="button" class="btn btn-success btn-xs">Become a new brain</button></a>	
			
	<h3>Hello dear. Wanna check the coolest ideas on Topaidi?</h3>
		
		<div class="container">
		<h1>Idea list</h1>
			<ul class="list-group">
				<div class="row border-top">
					<c:forEach items="${ideas}" var="idea">
						<div class="col-8 border-bottom border-left">
							<h5 class="mb-1">${idea.title}</h5>
							<p class="mb-1">Description : ${idea.description}</p>
						</div>
						<div class="col-4 border-bottom border-right">
							<c:if test="${idea.image == null}">
								<img src="https://freerangestock.com/sample/38789/lightbulb-with-idea-concept-icon.jpg" alt="${idea.title}"
									height="100" width="auto">
							</c:if>
							<c:if test="${idea.image != null}">
								<img src="${idea.image}" alt="${idea.title}" height="100" width="auto">
							</c:if>
						</div>
					</c:forEach>
				</div>
			</ul>
		
	</div>
		
</div>
</body>
</html>