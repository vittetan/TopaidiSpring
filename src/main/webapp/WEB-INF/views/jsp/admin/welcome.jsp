<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>
	<h1>WELCOME ADMIN</h1>

	<div class="panel-group" id="accordion">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse1">Unvalidated Brains</a>
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
								<spring:url value="/admin/activate/${user.id}" var="activateBrain" />
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
						href="#collapse2"> Collapsible Group 2</a>
				</h4>
			</div>
			<div id="collapse2" class="panel-collapse collapse">
				<div class="panel-body">
				
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapse3"> Collapsible Group 3</a>
				</h4>
			</div>
			<div id="collapse3" class="panel-collapse collapse">
				<div class="panel-body">
				
				</div>
			</div>
		</div>
	</div>











</div>
</body>
</html>