<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<h1>WELCOME TO OUR RANKINGS</h1>	

<br /> 

<div id="accordion">

    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          Ranking Tops
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-parent="#accordion">
        <div class="card-body">
        	<ol>
	          <c:forEach items="${rankingTop10}" var="top">
					<li>${top.title}: ${top.category.name} 
					</li>
			  </c:forEach>
			 </ol>
		</div>
      </div>
    </div>

	<div class="card">
      <div class="card-header"  style="text-align:right;">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          However... you haven't voted for this Tops
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-parent="#accordion" >
        <div class="card-body">
        	<ol><c:forEach items="${notVotedRankingTop10}" var="top">
					<li>${top.title}: ${top.category.name} 
					</li>
			  </c:forEach></ol>
		</div>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
        Ranking Buzz
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-parent="#accordion">
        <div class="card-body">
        	<ol>
	          <c:forEach items="${rankingBuzz10}" var="buzz">
					<li>${buzz.title}: ${buzz.category.name}
					</li>
			  </c:forEach>
			</ol>
		</div>
      </div>
    </div>
    
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
          Ranking Brains
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
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