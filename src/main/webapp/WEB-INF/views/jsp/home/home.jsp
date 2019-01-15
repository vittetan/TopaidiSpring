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

	<h1>Welcome to Topaidi. We are the best!</h1>
	<br /> 
	<a href="newBrain" class="btn btn-success btn-xs">Become a new brain</a>

	<h3>Hello dear. Wanna check the coolest ideas on Topaidi?</h3>

	<div class="container">
		<h1>Idea list</h1>

		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Title</th>
					<th scope="col">Description</th>
					<th scope="col">Category</th>
					<th scope="col">Image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ideas}" var="idea">
					<th scope="row">${idea.id}</th>
					<th scope="row">${idea.title}</th>
					<td>${idea.description}</td>
					<td>${idea.category.name}</td>
					<td><c:if test="${idea.image == null}">
							<img
								src="https://freerangestock.com/sample/38789/lightbulb-with-idea-concept-icon.jpg"
								alt="${idea.title}" height="100" width="auto">
						</c:if> <c:if test="${idea.image != null}">
							<img src="${idea.image}" alt="${idea.title}" height="100"
								width="auto">
						</c:if></td>
				</c:forEach>


			</tbody>
		</table>

	</div>

</div>
</body>
</html>