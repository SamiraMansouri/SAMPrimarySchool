<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>About Us</title>

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
  <li ><a href="/">Home</a></li>
  <li class="active"><a href="#">About Us</a></li>
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
          <h3>school</h3>
          <p>The atmosphere in school is good.</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/img/slider2.jpg" alt="school" width="460" height="345">
        <div class="carousel-caption">
          <h3>school</h3>
          <p>....</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources/img/slider5.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>Students</h3>
          <p>....</p>
        </div>
      </div>

      <div class="item">
        <img src="resources/img/slider6.jpg" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>learning</h3>
          <p>...</p>
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


<div >
    <h1>Welcome to SAM Primary School</h1> 
    <p>We are excited to introduce you to our school!</p> 
    <br>
    <p>
    Kingsley’s approach to teaching and learning is focused on each child’s individual potential, talents, and level of development — helping children learn in the best way for them. Our primary goal is to educate children as individuals, building on their curiosity and talents and empowering them to succeed socially and academically. 
    </p>
    <br>
    <p>
    	For children from Toddler through Sixth Grade, Kingsley offers an individualized education that is geared to the talents and the developmental level of each student. Children who complete our Early Childhood Program excel in elementary school. Our graduating students move on to top public and private schools, and our students perform exceptionally well on standardized tests. 
    	
    </p>
    
    <br>
    <p>
    The Montessori framework, proven through decades of success worldwide, incorporates best practices in 21st century education. Our approach cultivates critical thinking and creative problem-solving skills. It develops students who are inquisitive learners, responsible citizens, and trusted friends. 
    </p>
    <br>
    <p>
    It gives me special pleasure to note the prominence of the arts and our many specialist and extracurricular classes at Kingsley. We have always understood the value of these areas of study, both for the learning opportunities they present and for the richness they bring to our students, and we remain dedicated to including them as key elements of our curriculum. 
    </p>
    <br>
    <p>
    We invite you to explore our Early Childhood and Elementary Programs and learn more about our school and community. 
    </p>
    <br>
    <p>
    Sincerely,
    </p>
    <br>
    <br>
   <img src="resources/img/Signature.png" class="img-rounded" width="20%" height="20%">
   <br>
    <br>
    <p>Renee DuChainey-Farkes, Head of School</p>
    <br>
    <br>
    <br>
    
  </div>

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
