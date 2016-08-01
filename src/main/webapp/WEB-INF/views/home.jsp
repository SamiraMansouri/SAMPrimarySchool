<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/homeStylesheet.css">

</head>

<body>
<div class="container-fluid">



<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8 ">
<img src="resources/img/junespreprimary-logo.png" class="img-rounded" alt="Chania" width="100%" height="30%">



<ul class="nav nav-pills nav-justified bg-info">
  <li class="active"><a href="#">Home</a></li>
  <li><a href="<c:url value="/aboutUs" />">About Us</a></li>
  <li><a href="<c:url value="/gallery" />">Gallery</a></li>
    <li><a href="<c:url value="/application" />">Application</a></li>
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

<table >
<tbody>
<tr>
<td >
<div class="jumbotron bg-danger">
    <h4>Bootstrap Tutorial</h4> 
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing
    responsive, mobile-first projects on the web.</p> 
  </div>
</td>
<td width="20"></td>
<td >
<div class="jumbotron bg-warning">
   <h4>Bootstrap Tutorial</h4> 
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing
    responsive, mobile-first projects on the web.</p> 
  </div>
</td>
<td width="20"></td>
<td >
<div class="jumbotron bg-blue">
    <h4>Bootstrap Tutorial</h4> 
    <p>Bootstrap is the most popular HTML, CSS, and JS framework for developing
    responsive, mobile-first projects on the web.</p> 
  </div>
</td>
</tr>
</tbody>
</table>

</div>

<div class="col-md-2"></div>
</div>


  <footer class="footer">
  <div class="container">
  <div>
    <a class="footer-links" href="#">Home  </a>|
      <a class="footer-links"  href="<c:url value="/aboutUs" />">ABOUT US  </a>|
        <a class="footer-links"  href="<c:url value="/gallery" />">GALLARY </a>|
          <a class="footer-links"  href="<c:url value="/application" />">APPLICATION </a>|
           <a class="footer-links"  href="<c:url value="/contact" />">CONTACT </a>|
            <a class="footer-links"  href="<c:url value="/login" />">LOGIN </a>
   </div>
  </div>
</footer>
</div>

</body>
</html>
