<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../include/header.jsp" />

<div>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

          <!-- Title -->
          <h1 class="mt-4">${i.title}</h1>

          <!-- Author -->
          <p class="lead">
            by <b>${i.brain.pseudo}</b>
          </p>
          <hr>
          <br/>

          <!-- Preview Image -->         
          <img class="img-fluid rounded" src="${i.image}" alt="">
          <br/><br/>

          <!-- Post Content -->       
          <p>${i.description}</p>
          <br/>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">Leave a Comment:</h5>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <textarea class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
          </div>

          <!-- Single Comment -->
          <div class="media mb-4">
          <c:forEach items="${ideas}" var="idea">
            <img class="d-flex mr-3 rounded-circle" src="https://kotmo.ca/wp-content/uploads/2018/03/commentaire-sur-le-blog-symbole-de-bulle_318-64486.jpg" height="35px" width="auto" alt="">
            <div class="media-body">
              <h5 class="mt-0">sssssss</h5>
              <p>${i.comment.description}</p>
            </div>
          </c:forEach>
          </div>
         
        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">
        <br/> 
       
          <!-- Date Widget -->
          <div class="card">
  			<h5 class="card-header">Publication date</h5>
          	<blockquote class="blockquote text-center">
            	<h6 class="card-text"></h6>
  				<p class="mb-0">${i.dateCreation}</p>
		  	</blockquote>
		  </div>    
		  <br/> 
          
          <!-- Categories Widget -->
          <div class="card">
  			<h5 class="card-header">Category</h5>
          	<blockquote class="blockquote text-center">
            	<h6 class="card-text"></h6>
  				<p class="mb-0">${i.category.name}</p>
		  	</blockquote>
		  </div>    
		  <br/>      
          
          <!-- Ranking Tops Widget -->
          <div class="card">
  			<h5 class="card-header">Ranking Tops</h5>
          	<blockquote class="blockquote text-center">
          		<br/>
            	<h6 class="card-text">According to the percentage of Tops</h6>
  				<p class="mb-0">??????</p>
		  	</blockquote>
		  </div>
		  <br/>
          
          <!-- Ranking Brains Widget -->
          <div class="card">
  			<h5 class="card-header">Ranking Brains</h5>
          	<blockquote class="blockquote text-center">
          		<br/>
            	<h6 class="card-text">According to the number of ideas posted by user</h6>
  				<p class="mb-0">??????</p>
		  	</blockquote>
		  </div>
		  <br/>
          
          <!-- Ranking Buzz Widget -->
          <div class="card">
  			<h5 class="card-header">Ranking Buzz</h5>
          	<blockquote class="blockquote text-center">
          		<br/>
            	<h6 class="card-text">According to the number of total votes (Tops + Flops)</h6>
  				<p class="mb-0">??????</p>
		  	</blockquote>
		  </div>
		                    
        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
	
</div>
</body>
</html>