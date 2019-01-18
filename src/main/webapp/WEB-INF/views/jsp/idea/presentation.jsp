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
				<img class="rounded mx-auto d-block"
					src="https://freerangestock.com/sample/38789/lightbulb-with-idea-concept-icon.jpg"
					height="300px" width="auto">
			</c:if>
			<c:if test="${i.image != null}">
				<img class="rounded mx-auto d-block" src="${i.image}" height="300px"
					width="auto">
			</c:if>
			<br />

			<!-- Post Content -->
			<p class="idea-description">${i.description}</p>
			<br> <br>
			
			<!-- Report form -->
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse1">Report this idea</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<div class="panel-body">
							<spring:url value="/idea/${i.id}/report" var="reportThisIdea"/>
							<form:form method="POST" action="${reportThisIdea}" modelAttribute="reportIdea">
								<form:input path="description" class="form-control" />
								<br />
								<button type="submit" class="btn btn-danger">Report this idea</button>
							</form:form>
						</div>
						</div>
					</div>
			</div>

					<!-- Comments Form -->
					<div class="card my-4">
						<h4 class="card-header">Leave a Comment:</h4>
						<div class="card-body">
							<form:form method="POST" action="" modelAttribute="comm">
								<form:input path="idea.id" type="hidden" />
								<div class="form-group">
									<form:input class="form-control" path="description" />
								</div>
								<button type="submit" class="btn btn-primary">Submit
									Comment</button>
							</form:form>
						</div>
					</div>

					<!-- All comments -->
					<c:forEach items="${comments}" var="comment">
						<div class="media mb-4">
							<img class="d-flex mr-3 rounded-circle"
								src="https://kotmo.ca/wp-content/uploads/2018/03/commentaire-sur-le-blog-symbole-de-bulle_318-64486.jpg"
								height="35px" width="auto" alt="">
							<div class="media-body">
								<h4 class="mt-0">${comment.brain.pseudo}</h4>
								<p>${comment.description}</p>
								<spring:url value="/idea/${i.id}/reportComment/${comment.id}" var="reportComment"/>
								<a class="btn btn-danger btn-xs" href="${reportComment}" >Report this comment</a>
							</div>
						</div>
					</c:forEach>

				</div>
				<!-- Post Content Column -->

				<!-- Sidebar Widgets Column -->
				<div class="col-md-4">
					<br /> <br /> <br />

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
					<br /> <br /> <br />

					<!-- Ranking Tops Widget -->
					<div class="card">
						<h4 class="card-header">So much Tops!</h4>
						<blockquote class="blockquote text-center">
							<br />
							<h6 class="card-text">This idea has received </h6>
							<h4 class="mb-0">${ideaTops} Tops</h4>
						</blockquote>
					</div>
					<br />

					<!-- Ranking Buzz Widget -->
					<div class="card">
						<h4 class="card-header">Everyone's looking around!</h4>
						<blockquote class="blockquote text-center">
							<br />
							<h6 class="card-text">This idea has received </h6>
							<h4 class="mb-0">${ideaVotes} Votes</h4>
						</blockquote>
					</div>
					<br /> <br /> <br />

					<!-- Categories Widget -->
					<div class="card my-4">
						<h4 class="card-header">Vote</h4>
						<blockquote class="blockquote text-center">
							<div class="form-group">
								<br />
								<c:if test="${alreadyVoted}">

									<div class="alert alert-danger" role="alert">You
										already voted for this idea !</div>

									<div class="alert alert-success" role="alert">You have already voted for this idea !</div>

								</c:if>
								<c:if test="${not alreadyVoted}">
									<spring:url value="/idea/${i.id}?vote=top"
										var="redirectVoteTop" />
									<a class="btn btn-primary" href="${redirectVoteTop}">TOP</a>

									<spring:url value="/idea/${i.id}?vote=flop"
										var="redirectVoteFlop" />
									<a class="btn btn-primary" href="${redirectVoteFlop}">FLOP</a>
								</c:if>
							</div>
						</blockquote>
					</div>

				</div>
				<!-- Sidebar Widgets Column -->

			</div>
			<!-- /.row -->

		</div>
		</body>
		</html>