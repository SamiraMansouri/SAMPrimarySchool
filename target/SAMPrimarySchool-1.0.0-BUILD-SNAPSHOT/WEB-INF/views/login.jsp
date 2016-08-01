<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/homeStylesheet.css">

<style>
form
{
background-color:ffffff;
height:50%;
}

h4
{
color:white;
}

.form-content
{
margin:40px;
margin-top:40px;
}



</style>

 <script type="text/javascript">
        function loginToMainPage(){
			 window.location = '/spring/homePage';
        }
        </script>
</head>

<body>
<div class="container">


<br>
<br><br>
<br><br>
<br><br>
<br>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-5 " >

<form role="form " action="homePage.htm" method="POST">
<div class="well bg-danger"><h4 align="center"><b>SAM PRIMARY SCHOOL</b></h4></div>
<div class="form-content">
    <div class="form-group">
   
      <label for="username">Username:</label>
      <input type="text" class="form-control" name="username" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
   <input type="submit" name="operation" value="Post" >
  </div>
  </form>
  </div>
<br>
<br><br>
<br><br>
<br><br>
<br>

<div class="col-md-3"></div>
</div>

</div>

</body>
</html>
