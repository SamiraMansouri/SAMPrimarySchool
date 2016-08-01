<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/homeStylesheet.css">
	    <script src="http://bootboxjs.com/bootbox.js"></script>
<style>
.h1 {
	margin-bottom: 3%;
}

.panel {
	border: solid;
	border-color: #283891;
	margin-top: 30%;
}



.table{
margin-top:10%;}

.table-bordered > thead ,
.table-bordered > thead > tr > th,
.table-bordered > tbody > tr > th,
.table-bordered > thead > tr > td,
.table-bordered > tbody > tr > td{
  border: 3px solid #283891;
  width:100;
}

.btn
{
margin-top: 20%;
 margin-bottom:30%;
 margin-right:3%;
}
.footer {
	background: #283891;
	text-align: center;
	color: #ffffff;
	height: 5%;
}

h1, h4 {
	color: #283891;
}

#btn {
	color: white;
	width: 100%;
	height: 5%;
	margin-right: 10%;
}
</style>
</head>

<body>
	<div class="container-fluid">

		<div class="row">
			<img src="resources/img/junespreprimary-logo.png" class="img-rounded"
				alt="Chania" width="100%" height="40%">
		</div>

		<!-- row -->
		<div class="row">
						<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-body">
						<ul class="nav nav-pills nav-stacked">
							<li class="active"><a href="#">Home</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Assignment <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/SAMPrimarySchool/AddNewAssignment">Add
											New Assignment</a></li>
									<li><a href="/SAMPrimarySchool/AssignmentsList">My
											Assignments</a></li>
									<li><a href="/SAMPrimarySchool/AssignmentsList">List
											of Assignments</a></li>
								</ul></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Announcement <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Add New Announcement</a></li>
									<li><a href="#">My Announcements</a></li>
									<li><a href="#">List of Announcements</a></li>
								</ul></li>

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Grade List <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="/SAMPrimarySchool/AddGradeList">Add New
											Grade List</a></li>
									<li><a href="#">My Grades</a></li>
									<li><a href="/SAMPrimarySchool/GradeLists">List of
											Grade Lists</a></li>
								</ul></li>
							
							<li><a href="#">Class Info</a></li>

							<li><a href="#"><span class="glyphicon glyphicon-user"></span>
									Sign Up</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<c:if test="${not empty assignmentsList}">
					<table class="table-bordered table-hover table">
						<thead>
							<tr class="text-xs-center font-weight-bold text-primary" >
								<th>Subject</th>
								<th>Deadline</th>
								<th>Date</th>
								<th>Show</th>
							</tr>

							<c:forEach var="assignment" items="${assignmentsList }">
								<tr>
								
									<!-- subject -->
									<td><label >${assignment.subject}</label></td>
									<!-- subject -->

									<!-- deadline -->
									<td><label >${assignment.deadline}</label></td>
									<!-- deadline -->

									<!-- date -->
									<td><label >${assignment.creationDate}</label></td>
									<!-- date -->
									
									<!-- show Assignment -->	
									<td>	 <a href="ShowAssignment.htm?assignmentId=${assignment.id}">Show</a></td>
									<!-- show Assignment -->

								</tr>

							</c:forEach>
						</thead>
					</table>
					
						
						
				</c:if>
				<c:if test="${empty assignmentsList }">
					<div class="panel panel-default">
						<div class="panel-body">There is no assignment</div>
					</div>
				</c:if>
			</div>
		</div>

		<!-- end of row -->

		<!-- footer -->
		<footer class="footer">
			<div class="container">
				<div>
					<a class="footer-links" href="#">Home </a>| <a class="footer-links"
						href="<c:url value="/aboutUs" />">ABOUT US </a>| <a
						class="footer-links" href="<c:url value="/gallery" />">GALLARY
					</a>| <a class="footer-links" href="<c:url value="/application" />">APPLICATION
					</a>| <a class="footer-links" href="<c:url value="/contact" />">CONTACT
					</a>| <a class="footer-links" href="<c:url value="/login" />">LOGIN
					</a>
				</div>
			</div>
		</footer>
		<!-- footer -->
	</div>

</body>
</html>
