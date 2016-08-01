<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Contact</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/homeStylesheet.css">

<style>
.jumbotron
{
background-color: #ff3333;
}


</style>
</head>

<body>
<div class="container-fluid">



<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8 ">
<img src="resources/img/junespreprimary-logo.png" class="img-rounded" alt="Chania" width="100%" height="30%">



<ul class="nav nav-pills nav-justified bg-info">
  <li ><a href="/">Home</a></li>
  <li><a href="<c:url value="/aboutUs" />">About Us</a></li>
  <li><a href="<c:url value="/gallery" />">Gallery</a></li>
    <li><a href="<c:url value="/application" />">Application</a></li>
  <li class="active"><a href="<c:url value="#" />">Contact</a></li>
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
        <img src="resources/img/slider7.jpg" alt="Chania" width="460" height="345">
        <div class="carousel-caption">
          <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/img/slider2.jpg" alt="Chania" width="460" height="345">
        <div class="carousel-caption">
          <h3>Chania</h3>
          <p>The atmosphere in Chania has a touch of Florence and Venice.</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources/img/slider5.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>Flowers</h3>
          <p>Beatiful flowers in Kolymbari, Crete.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/img/slider6.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>Flowers</h3>
          <p>Beatiful flowers in Kolymbari, Crete.</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true" ></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>


<br>

<table class="cl-md-8" style="width:100%;">
<tbody>

<tr class="cl-md-8" >
<td width="40%">
	<h2>CONTACT DETAILS</h2>
		
			<p>
				SAM Primary School<br>
				21 Langford Road<br>
				Boston<br>
				36239<br>
				<strong>Email :</strong> <a class="email" href="mailto:info@samprimary.co.za">info@junespreprimary.co.za</a><br>
				<strong>Tel :</strong> 124 654 3122<br>
				<strong>Cell :</strong> 657 636 4567
			</p>
			
			<p>	
				<strong>Find us :</strong> <a target="_new" href="https://www.google.com/maps/place/111+Norway+St,+Boston,+MA+02115/@42.345466,-71.0909677,17z/data=!3m1!4b1!4m2!3m1!1s0x89e37a1ba962bc4b:0xfbc27f4a9f722be6?hl=en" class="ablue">Map &amp; Directions</a><br>
			</p>
			
			<p>	
				<strong>Our hours are as follows:</strong> <br>
				<strong>School :</strong> 07.15am - 12.00pm (School Terms only) <br>
			</p>
</td>
<td width="10%"></td>
<td class="contact-form"  width="60%">
<div class="jumbotron ">
  <form role="form">
    <div class="form-group">
     <label for="FirstName">First Name:</label>
      <input type="text" class="form-control" id="FirstName" placeholder="Enter first name">
      </div>
          <div class="form-group">
      <label for="LastName">Last Name:</label>
      <input type="text" class="form-control" id="LastName" placeholder="Enter Last name">
      </div>
          <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email">
    </div>

    <div class="form-group">
  <label for="comment">Comment:</label>
  <textarea class="form-control" rows="5" id="comment"></textarea>
	</div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  </div>

</td>
</tr>
<tr></tr>
</tbody>
</table>

</div>

<div class="col-md-2"></div>
</div>


  <footer class="footer">
  <div class="container">
  <div>
    <a class="footer-links" href="/">Home  </a>|
      <a class="footer-links"  href="<c:url value="/aboutUs" />">ABOUT US  </a>|
        <a class="footer-links"  href="<c:url value="/gallery" />">GALLARY </a>|
          <a class="footer-links"  href="<c:url value="/application" />">APPLICATION </a>|
           <a class="footer-links"  href="<c:url value="#" />">CONTACT </a>|
            <a class="footer-links"  href="<c:url value="/login" />">LOGIN </a>
   </div>
  </div>
</footer>
</div>

</body>
</html>
