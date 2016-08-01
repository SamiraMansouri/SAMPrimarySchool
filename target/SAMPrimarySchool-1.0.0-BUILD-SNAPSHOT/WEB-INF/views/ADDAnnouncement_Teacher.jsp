<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already used Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

<style>
.h1 {
	margin-bottom: 3%;
}

.panel {
	border: solid;
	border-color: #283891;
	margin-top: 40%;
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
		<div class="row">

			<!-- left menue -->
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
			<!-- left menue -->

			<!-- dropdownlist -->
			<div class="col-md-9">

				<!-- messages -->

				<form:form modelAttribute="announcement" action="addAnnouncement_Teacher" method="post" enctype="multipart/form-data">
						<fieldset>
					<h1>New Announcement</h1>
					<!-- messages -->
					<c:if test="${message=='success'}">
						<div class="alert alert-success fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success!</strong> The assignment uploaded successfully.
						</div>
					</c:if>
					<c:if test="${empty message }">
						<div class="alert alert-info fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Info!</strong> Please fill all the boxes.
						</div>
					</c:if>
					<c:if test="${(message!='success') && (not empty message)}">
						<div class="alert alert-danger fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${message }
						</div>
					</c:if>
					<!-- messages -->

					<!-- subject -->
					<div style="margin-top: 5%;">
						<form:label for="subject" path="subject">subject:</form:label>
						<br />
						<form:input path="subject" />
						<form:errors path="subject" />
					</div>
					<!--  subject -->

					<!-- Description -->
					<div style="margin-top: 5%;">
						<form:label for="content" path="content">description:</form:label>
						<br />
						<form:input path="content" />
						<form:errors path="content" />
					</div>
					<!-- Description -->

					<div>
						<input type="submit" name="operation" class="btn btn-primary"
							value="Post" style="margin-top: 20%; margin-bottom: 20%;">
					</div>
					</fieldset>
				</form:form>

			</div>
		</div>
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

	</div>
</body>
</html>
