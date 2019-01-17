<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>

<spring:url value="/brain/${brainId}/newIdea" var="newIdeaUrl"/>
<spring:url value="/brain/${brainId}/rankings" var="rankingsUrl"/>

<h1>WELCOME BRAIN</h1>	
	
	<div class="brain">
        <div class="row">
          <div class="col-lg-8 mx-auto text-center">
            <h2 class="section-heading text-black">New Idea ?</h2>
            <hr class="light my-4">
            <p class="text-faded mb-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
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
            <p class="text-faded mb-4">Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <a href="${rankingsUrl}" class="btn btn-light btn-xl js-scroll-trigger">Go to the Rankings !</a>
          </div>
        </div>
    </div>
    
    <br />

</div>
</body>
</html>