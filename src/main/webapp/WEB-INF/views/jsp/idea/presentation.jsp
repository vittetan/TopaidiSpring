<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div>

	<!-- /.row -->
	<div class="row">

		<!-- Post Content Column -->
		<div class="col-lg-8">

			<!-- Title -->
			<br />
			<h1 class="mt-4">${i.title}</h1>

			<!-- Author -->
			<p class="lead">
				by <b>${i.brain.pseudo}</b>
			</p>
			<hr>
			<br />

			<!-- Preview Image -->
			<c:if test="${i.image == null}">
				<img  class="rounded mx-auto d-block" src="https://freerangestock.com/sample/38789/lightbulb-with-idea-concept-icon.jpg" height="300px" width="auto">
			</c:if>
			<c:if test="${i.image != null}">
				<img  class="rounded mx-auto d-block" src="${i.image}" height="300px" width="auto">
			</c:if>
			<br />

			<!-- Post Content -->
			<p class="idea-description">${i.description}</p>
			<br />

			<!-- Comments Form -->
			<div class="card my-4">
				<h4 class="card-header">Leave a Comment:</h4>
				<div class="card-body">
					<form:form method="POST" action="" modelAttribute="comm">
						<form:input path="idea.id" type="hidden" />
						<div class="form-group">
							<form:input class="form-control" path="description" />
						</div>
						<button type="submit" class="btn btn-primary">Submit Comment</button>
					</form:form>
				</div>
			</div>

			<!-- Single Comment -->
			<c:forEach items="${comments}" var="comment">
				<div class="media mb-4">
					<img class="d-flex mr-3 rounded-circle"
						src="https://kotmo.ca/wp-content/uploads/2018/03/commentaire-sur-le-blog-symbole-de-bulle_318-64486.jpg"
						height="35px" width="auto" alt="">
					<div class="media-body">
						<h4 class="mt-0">${comment.brain.pseudo}</h4>
						<p>${comment.description}</p>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- Post Content Column -->

		<!-- Sidebar Widgets Column -->
		<div class="col-md-4">
			<br />
			<br />
			<br />

			<!-- Date Widget -->
			<div class="card">
				<h4 class="card-header">Publication date</h4>
				<blockquote class="blockquote text-center">
					<h6 class="card-text"></h6>
					<h4 class="mb-0">${i.dateCreation}</h4>
				</blockquote>
			</div>
			<br />

			<!-- Categories Widget -->
			<div class="card">
				<h4 class="card-header">Category</h4>
				<blockquote class="blockquote text-center">
					<h6 class="card-text"></h6>
					<h4 class="mb-0">${i.category.name}</h4>
				</blockquote>
			</div>
			<br />
			<br />
			<br />

			<!-- Ranking Tops Widget -->
			<div class="card">
				<h4 class="card-header">Ranking Tops</h4>
				<blockquote class="blockquote text-center">
					<br />
					<h6 class="card-text">According to the percentage of Tops</h6>
					<h4 class="mb-0">??????</h4>
				</blockquote>
			</div>
			<br />

			<!-- Ranking Buzz Widget -->
			<div class="card">
				<h4 class="card-header">Ranking Buzz</h4>
				<blockquote class="blockquote text-center">
					<br />
					<h6 class="card-text">According to the number of total votes
						(Tops + Flops)</h6>
					<h4 class="mb-0">??????</h4>
				</blockquote>
			</div>
			<br />
			<br />
			<br />				

			<!-- Categories Widget -->
			<div class="card my-4">
				<h4 class="card-header">Vote</h4>
				<blockquote class="blockquote text-center">
					<form:form method="POST" action="${i.id}/vote" modelAttribute="voteIdea">
						<div class="form-group">			
							<br />
							<a class="btn btn-primary" href="?vote=top">TOP</a>
							<a class="btn btn-primary" href="?vote=flop">FLOP</a>		
						</div>
					</form:form>
				</blockquote>
			</div>

		</div>
		<!-- Sidebar Widgets Column -->

	</div>
	<!-- /.row -->

</div>
</body>
</html>