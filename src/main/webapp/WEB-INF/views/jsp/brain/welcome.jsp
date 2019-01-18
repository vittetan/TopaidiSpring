<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<spring:url value="/brain/${brainId}/newIdea" var="newIdeaUrl"/>
<spring:url value="/brain/${brainId}/rankings" var="rankingsUrl"/>

<h1>WELCOME BRILLIANT BRAIN</h1>
<h2>How are you today <strong style="color:Blue;"><i>${brainPseudo}</i></strong>?</h2>
<h3>There is not need to say we hope you are feeling okay to share you ideas or your opinions.</h3>
	
	<div class="brain">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-black">New Idea ?</h2>
            <hr class="light my-4">
            <h3 class="text-faded mb-4">Is everything ringing a bell in your head?</h3>
            <a href="${newIdeaUrl}" class="btn btn-light btn-xl js-scroll-trigger">Let's share a new idea !</a>
          </div>
        </div>
    </div>
    
    <br />
    
    	<div class="brain">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-black">Rankings</h2>
            <hr class="light my-4">
            <h3 class="text-faded mb-4">Take a look of our community best thoughts...</h3>
            <a href="${rankingsUrl}" class="btn btn-light btn-xl js-scroll-trigger">Go to the Rankings !</a>
          </div>
        </div>
    </div>
    
    <br />

</div>
</body>
</html>