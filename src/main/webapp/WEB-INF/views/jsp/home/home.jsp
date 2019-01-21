<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />



<c:if test="${action == 'confirm'}">
	<div class="alert alert-success" role="alert">We have received
		your request. If all you data are OK you'll become a Brain in very
		short time. Congratulations!</div>
</c:if>

<div>

	<h1>Welcome to Topaidi. The only network to share ideas!</h1>
	

	<h4>Hello! Joining Topaidi will let you share you own ideas and evaluate <i><b style="font-size:60%">(Top if you like if, Flop if not so much)</b></i> and comment other brains' ideas.  </h4>

	<h4>Our rankings will show you the best noted ideas <i>(Ranking Top)</i>, the most voted ideas <i>(Ranking Buzz)</i>, and the most active brains <i>(Ranking Brains).</i></h4>
		
	<h3>Wanna check the coolest ideas on Topaidi?</h3>
	
	  <br/>
	  <hr>

      <!-- Project One -->
      <c:forEach items="${ideas}" var="idea">
      <spring:url value="/idea/${idea.id}" var="ideaUrl"/>
      <div class="row">
        <div class="col-md-7">        
          	<c:if test="${idea.image == null}">
				<img  class="rounded mx-auto d-block" src="https://freerangestock.com/sample/38789/lightbulb-with-idea-concept-icon.jpg" alt="${idea.title}" height="auto" width="200px">
			</c:if>
			<c:if test="${idea.image != null}">
				<img  class="rounded mx-auto d-block" src="${idea.image}" alt="${idea.title}" height="auto" width="250px">
			</c:if>
        </div>
        <div class="col-md-5">
          <h2>${idea.title}</h2>
          <h4><b>Category: </b>${idea.category.name}</h4>
          <p>${idea.description}</p>
          <a class="btn btn-primary" href="${ideaUrl}">View Idea</a>
        </div>
      </div>
      <hr>
      </c:forEach>
      <!-- /.row -->

</div>
</body>
</html>