<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../include/header.jsp" />

<div>
	<h1>WELCOME ADMIN</h1>	
	
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
		<tr>
			<th scope="row">${user.id}</th>
			<td>${user.pseudo}</td>
			<td>${user.login}</td>
			<td><a class="btn btn-success" href="#">Validate</a></td>
		</tr>
	</c:forEach>
  </tbody>
</table>
	
	
	

</div>
</body>
</html>