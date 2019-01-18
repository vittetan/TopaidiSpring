<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../include/header.jsp" />

<div>
	<h1>WELCOME ADMIN</h1>

	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse1">Unvalidated Brains (${fn:length(unvalidatedUsers)})</a>
				</h4>
			</div>
			<div id="collapse1" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Pseudo</th>
								<th scope="col">Mail</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${unvalidatedUsers}" var="user">
								<spring:url value="/admin/activate/${user.id}"
									var="activateBrain" />
								<tr>
									<th scope="row">${user.id}</th>
									<td>${user.pseudo}</td>
									<td>${user.login}</td>
									<td><a class="btn btn-success" href="${activateBrain}">Validate</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse2">Categories</a>
				</h4>
			</div>
			<div id="collapse2" class="panel-collapse collapse">
				<div class="panel-body">
					<spring:url value="/admin/addCategory" var="addCategory" />
					<form:form method="POST" action="${addCategory}"
						modelAttribute="newCategory">
						<table class="table">
							<thead class="thead-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">Name</th>
									<th scope="col">Description</th>
									<th scope="row">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${categories}" var="category">
									<tr>
										<th scope="row">${category.id}</th>
										<td>${category.name}</td>
										<td>${category.description}</td>
									</tr>
								</c:forEach>
								<tr>
									<th scope="row"></th>
									<td><div class="form control">
											<form:input path="name" />
										</div></td>
									<td><div class="form control">
											<form:input path="description" />
										</div></td>
									<td><button class="btn btn-success" type="submit">Add
											a category</button></td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse3">Reports about the ideas (${fn:length(reportIdeas)})</a>
				</h4>
			</div>
			<div id="collapse3" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">#</th>
								<th scope="row">Idea</th>
								<th scope="col">Brain</th>
								<th scope="col">Description</th>
								<th scope="row">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reportIdeas}" var="reportIdea">
								<tr>
									<th scope="row">${reportIdea.id}</th>
									<td>
									<spring:url value="/idea/${reportIdea.idea.id}" var="viewIdea" /> 
									<a class="btn btn-success"href="${viewIdea}">View Idea</a>
									</td>
									<td>${reportIdea.brain.pseudo}</td>
									<td>${reportIdea.description}</td>
									<td><spring:url
											value="/admin/desactivateBrain/${reportIdea.idea.brain.id}"
											var="desactivateBrain" /> <a class="btn btn-danger"
										href="${desactivateBrain}">Desactivate Idea's Brain</a> <spring:url
											value="/admin/desactivateIdea/${reportIdea.idea.id}"
											var="desactivateIdea" /> <a class="btn btn-danger"
										href="${desactivateIdea}">Desactivate Idea</a> <spring:url
											value="/admin/deleteReportIdea/${reportIdea.id}"
											var="deleteReportIdea" /> <a class="btn btn-danger"
										href="${deleteReportIdea}">Delete Report</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse4">Reports about the comments (${fn:length(reportComments)})</a>
				</h4>
			</div>
			<div id="collapse4" class="panel-collapse collapse">
				<div class="panel-body">
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">#</th>
								<th scope="row">Comment</th>
								<th scope="col">Brain</th>
								<th scope="col">Description</th>
								<th scope="row">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reportComments}" var="reportComment">
								<tr>
									<th scope="row">${reportComment.id}</th>
									<td>${reportComment.comment.description}</td>
									<td>${reportComment.brain.pseudo}</td>
									<td>${reportComment.description}</td>
									<td>
										<spring:url value="/admin/desactivateBrain/${reportComment.comment.brain.id}" var="desactivateBrain"/>
										<a class="btn btn-danger" href="${desactivateBrain}">Desactivate Brain</a>
										
										<spring:url value="/admin/desactivateComment/${reportComment.comment.id}" var="desactivateComment"/>
										<a class="btn btn-danger" href="${desactivateComment}">Desactivate Comment</a>
										
										<spring:url value="/admin/deleteReportComment/${reportComment.id}" var="deleteReportComment" /> 
										<a class="btn btn-danger" href="${deleteReportComment}">Delete Report</a>
										
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>





		</div>
	</div>
</div>
</body>
</html>