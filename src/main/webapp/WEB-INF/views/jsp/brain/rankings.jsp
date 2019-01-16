<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>WELCOME TO OUR RANKINGS</h1>	

<br /> 
	
	<div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
        Ranking Tops</a>
      </h4>
    </div>
    <div id="collapse1" class="panel-collapse collapse">
      <div class="panel-body">
      	<ol>
	      	<c:forEach items="${rankingTop10}" var="top">
				<li>${top.title}: ${top.category.name} 
				</li>
			</c:forEach>
		</ol>
	  </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
        Ranking Buzz</a>
      </h4>
    </div>
    <div id="collapse2" class="panel-collapse collapse">
      <div class="panel-body">
		<ol>
	    	<c:forEach items="${rankingBuzz10}" var="buzz">
				<li>${buzz.title}: ${buzz.category.name}
				</li>
			</c:forEach>
		</ol>
	  </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
        Ranking Brains</a>
      </h4>
    </div>
    <div id="collapse3" class="panel-collapse collapse">
      <div class="panel-body">
	  	<ol>
	    	<c:forEach items="${rankingBrains}" var="brain">
				<li>${brain.pseudo}
				</li>
			</c:forEach>
		</ol>
	  </div>
    </div>
  </div>
</div>

<br/>
<spring:url value="/brain/${brain.id}" var="url"></spring:url>
<a href="${url}" class="btn btn-primary btn-xs">Back</a>
	
		

</div>
</body>
</html>