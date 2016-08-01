<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="false"%>
<html>
<head>
<title>Add Grade List</title>

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
<script type="text/javascript">
	function validateForm() {
		var message = null;
		var date = document.forms["myForm"]["date"].value;
		if (date == null || date == "") {

			message = "please fill date"
		}

		var subject = document.forms["myForm"]["subject"].value;
		if (subject == null || subject == "") {
			if (message == null || message == "") {
				message = " please fill subject";
			} else {
				message = "and subject";
			}
		}

		var scale = document.forms["myForm"]["scale"].value;
		if (scale == null || scale == "") {
			if (message == null || message == "") {
				message = " please fill scale";
			} else {
				message = "and scale";
			}
		}

		if (message != null) {

			var e = document.getElementById('error');
			e.style.display = 'block';
			document.getElementById("errormsg").value = "dihwi";
			return false;
		}

	}
</script>
<style>
.h1 {
	margin-bottom: 3%;
}

.table-bordered>thead, .table-bordered>thead>tr>th, .table-bordered>tbody>tr>th,
	.table-bordered>thead>tr>td, .table-bordered>tbody>tr>td {
	border: 3px solid #283891;
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
<script>
	$(document).ready(function() {
		$('#datePicker').datepicker({
			format : 'mm/dd/yyyy'
		}).on('changeDate', function(e) {
			// Revalidate the date field
			$('#eventForm').formValidation('revalidateField', 'date');
		});

		$('#eventForm').formValidation({
			framework : 'bootstrap',
			icon : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				name : {
					validators : {
						notEmpty : {
							message : 'The name is required'
						}
					}
				},
				date : {
					validators : {
						notEmpty : {
							message : 'The date is required'
						},
						date : {
							format : 'MM/DD/YYYY',
							message : 'The date is not a valid'
						}
					}
				}
			}
		});
	});
</script>
</head>

<body>
	<div class="container-fluid">

		<div class="row">
			<img src="resources/img/junespreprimary-logo.png" class="img-rounded"
				alt="Chania" width="100%" height="40%">
		</div>
		<div class="row">

			<!-- left menu -->
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
								data-toggle="dropdown" href="#">Pre-Studying <span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">Add New Pre-Studying</a></li>
									<li><a href="#">My Pre-Studyings</a></li>
									<li><a href="#">List of Pre-Studyings</a></li>
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
			<!-- left menu -->

			<!-- Grade List -->
			<div class="col-md-9">
				<form name="myForm" role="form " action="AddGradeList.htm"
					onsubmit="return validateForm()" method="POST">

					<h1>New Grade List</h1>

					<!-- success message -->
					<c:if test="${message=='success'}">
						<div class="alert alert-success fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success!</strong> The new grade list added successfully.
						</div>
					</c:if>
					<!-- success message -->

					<!-- Warning message -->
					<c:if test="${empty message }">
						<div class="alert alert-info fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Info!</strong> Please fill all the boxes.
						</div>
					</c:if>
					<!-- warning message -->

					<!-- error in db message -->
					<c:if test="${(message!='success') && (not empty message)}">
						<div class="alert alert-danger fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Error!</strong> ${message }
						</div>
					</c:if>

					<div class="alert alert-danger fade in" id="error"
						style="display: none;">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Error!</strong> <label id="errormsg">Please Fill
							all the information!!</label>
					</div>
					<!-- error in db message -->

					<!-- Grade list subject -->
					<div style="margin-top: 5%;">
						<h4>Subject</h4>
						<textarea class="form-control" rows="1" id="subject"
							name="subject">${gradeList.subject }</textarea>
					</div>
					<!-- Grade list subject -->

					<!-- Date -->
					<div style="margin-top: 5%;">
						<h4>Date</h4>

						<div class="input-group input-append date" id="datePicker">
							<input type="text" class="form-control" name="date"
								value="${gradeList.date }" /> <span
								class="input-group-addon add-on"><span
								class="glyphicon glyphicon-calendar"></span></span>
						</div>
						<!-- Date -->

						<!-- scale -->
						<div style="margin-top: 5%;">
							<h4>Scale</h4>
							<textarea class="form-control" rows="1" id="scale" name="scale">${gradeList.scale }</textarea>
						</div>
						<!-- Scale -->
						<!-- Description -->
						<div style="margin-top: 5%;">
							<h4>Brief Description</h4>
							<textarea class="form-control" rows="7" id="description"
								name="description">${gradeList.content }</textarea>
						</div>
						<!-- Description -->

						<table class="table-bordered table-hover table"
							style="margin-top: 10%;">
							<thead>
								<tr class="text-xs-center font-weight-bold text-primary">
									<th>Image</th>
									<th>Name</th>
									<th style="width: 5%;">Grade</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="student" items="${students }">
									<tr>
										<!-- image -->
										<td><img
											src="http://www.clker.com/cliparts/N/j/z/I/u/F/red-man-hi.png"
											class="img-rounded" alt="Chania" height="10%"></td>
										<!-- image -->
										<td>${student.firstName} ${student.lastName}</td>

										<!-- Grade -->
										<td><input type="text" class="form-control"
											name="${student.iD}"></td>
										<!-- Grade -->

										<!-- Description -->
										<td><input type="text" class="form-control"
											name="gd${student.iD}"></td>
										<!-- Description -->
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</div>
				<br> <br> <br> <br> <br> <br> <br>
				<div><input type="submit" name="operation" class="btn btn-primary"value="Post" > </div>
			
				</form>
				<br> <br> <br> <br> <br> <br> <br>
				<br>
			</div>
		</div>

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
