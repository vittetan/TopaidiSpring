<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<link href="https://fonts.googleapis.com/css?family=Righteous" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" integrity="sha384-/rXc/GQVaYpyDdyxK+ecHPVYJSN9bmVFBvjA/9eOB+pb3F2w2N6fc5qB9Ew5yIns" crossorigin="anonymous">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/css/style.css"/>"/>
</head>

<body>
<div>

<div class="subscribe-login-signout">
	<spring:url value="/newBrain" var="subscribeRedirect"/>
	<a href="${subscribeRedirect}" class="btn btn-primary btn-xs">Subscribe</a>
	<spring:url value="/login" var="loginRedirect"/>
	<a href="${loginRedirect}" class="btn btn-primary btn-xs">Login</a>
	<spring:url value="/login/logout" var="signOut"/>
	<a href="${signOut}" class="btn btn-primary btn-xs">Sign out</a>
</div>

<header>
	<h1 class="titre-topaidi">TOPAIDI</h1>
</header>

      <spring:url value="/home" var="home"/>
      <spring:url value="/brain/0/newIdea" var="newIdeaUrl"/>
      <spring:url value="/brain/0/rankings" var="rankingsUrl"/>
		
<nav>
	<a href="${home}" title="accueil">Home</a>
	<a href="${newIdeaUrl}" title="newIdeaUrl">New Idea</a>
	<a href="${rankingsUrl}" title="rankingsUrl">Rankings</a>
</nav>
</div>