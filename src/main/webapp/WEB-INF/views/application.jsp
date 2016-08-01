<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Application</title>

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

<style>
h1, h3 {
	color: #cc0052;
}
</style>
</head>

<body>
	<div class="container-fluid">



		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8 ">
				<img src="resources/img/junespreprimary-logo.png"
					class="img-rounded" alt="Chania" width="100%" height="30%">



				<ul class="nav nav-pills nav-justified bg-info">
					<li><a href="/">Home</a></li>
					<li><a href="/aboutUs">About Us</a></li>
					<li><a href="<c:url value="/gallery" />">Gallery</a></li>
					<li class="active"><a href="<c:url value="#" />">Application</a></li>
					<li><a href="<c:url value="/contact" />">Contact</a></li>
					<li><a href="<c:url value="/login" />">Login</a></li>
				</ul>




				<br>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">

						<div class="item active">
							<img src="resources/img/slider7.jpg" alt="Chania" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Chania</h3>
								<p>The atmosphere in Chania has a touch of Florence and
									Venice.</p>
							</div>
						</div>

						<div class="item">
							<img src="resources/img/slider2.jpg" alt="Chania" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Chania</h3>
								<p>The atmosphere in Chania has a touch of Florence and
									Venice.</p>
							</div>
						</div>

						<div class="item">
							<img src="resources/img/slider5.jpg" alt="Flower" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Flowers</h3>
								<p>Beatiful flowers in Kolymbari, Crete.</p>
							</div>
						</div>

						<div class="item">
							<img src="resources/img/slider6.jpg" alt="Flower" width="460"
								height="345">
							<div class="carousel-caption">
								<h3>Flowers</h3>
								<p>Beatiful flowers in Kolymbari, Crete.</p>
							</div>
						</div>

					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>


				<br>


				<div>
					<h1>How to Apply</h1>
					<p>Thank you for your interest in Kingsley!</p>
					<br>
					<h3>Admission for the 2016-17 School Year</h3>
					<p>We have limited seats still available for our expanded
						Elementary Program for the 2016-17 academic year. Please contact
						Amy Weed to inquire about admissions for Kindergarten through
						Sixth Grade. The application deadline for our Early Childhood
						Program has passed. Applications submitted past January 15 for the
						Early Childhood Program will be considered after March 10. To
						receive our Viewbook and Application, submit an Online Inquiry
						Form, download our Admissions Package, or contact Amy Weed to have
						an application mailed to you.</p>
					<br>
					<h3>Admission Timeline</h3>
					<ul>
						<li>Saturday, Jan. 2– Preliminary Financial Aid application
							due</li>

						<li>Friday, Jan. 15– Application due</li>


						<li>Sunday, Jan. 31– School Records and AISNE student
							evaluation forms due</li>


						<li>Friday, Feb. 12– Toddler and Preschool applicant visits</li>

						<li>Thursday, Mar. 10– Admissions decisions; letter mailed to
							families</li>

						<li>Monday, Apr. 11– Family reply to Kingsley</li>

					</ul>
					<h3>Parent Visit</h3>
					<p>After we receive your application, we will invite you to
						tour the school, observe in a classroom, and meet with Amy.</p>

					<h3>Student Visit</h3>
					<p>We will make arrangements for your child to visit one of our
						classrooms and meet our teachers. Visits for the 2016-17
						applicants for Kingsley’s Toddler and Preschool Programs will be
						scheduled by appointment on Friday, February 12, 2016. Other
						applicants will be scheduled by appointment. The Admissions office
						is located in our Early Childhood building at 30 Fairfield Street.
						The Kingsley Montessori School does not discriminate on the basis
						of race, color, gender, sexual orientation, family composition,
						nationality, marital status, ethnic origin, or disability. We base
						our acceptance upon the appropriateness of the school for each
						individual student and his/her family.</p>
				</div>

			</div>

			<div class="col-md-2"></div>
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
