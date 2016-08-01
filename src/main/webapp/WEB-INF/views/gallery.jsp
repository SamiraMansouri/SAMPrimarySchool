<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Gallery</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/homeStylesheet.css">
 <style>
    @import url(https://fonts.googleapis.com/css?family=Bree+Serif);
    
      ul {
          padding:0 0 0 0;
          margin:0 0 40px 0;
      }
      ul li {
          list-style:none;
          margin-bottom:10px;
      }
      ul li img {
          cursor: pointer;
      }
      .modal-body {
          padding:5px !important;
      }
      .modal-content {
          border-radius:0;
      }
      .modal-dialog img {
          text-align:center;
          margin:0 auto;
      }
    .controls{
        width:50px;
        display:block;
        font-size:11px;
        padding-top:8px;
        font-weight:bold;
    }
    .next {
        float:right;
        text-align:right;
    }
    .text {
      font-family: 'Bree Serif';
      color:#666;
      font-size:11px;
      margin-bottom:10px;
      padding:12px;
      background:#fff;
    }
      /*override modal for demo only*/
      .modal-dialog {
          max-width:500px;
      }
      @media screen and (min-width: 768px){
          .modal-dialog {
              width:500px;
          }
      }
      @media screen and (max-width: 380px){
         .col-xxs-12 {
           width:100%;
         }
         .col-xxs-12 img {
           width:100%;
         }
      }
  </style>
  <script>
  (function(){
  	"use strict";
  	var clicked = {};
  	function showModal(){
  			var src = $(this).attr('src');
  			var img = '<img src="' + src + '" class="img-responsive"/>';
  			var index = $(this).parent('li').attr('data-index');
  			clicked.prevImg = parseInt(index) - parseInt(1);
  			clicked.nextImg = parseInt(index) + parseInt(1);
  			var html = '';
  			html += img;
  			html += '<div style="height:25px;clear:both;display:block;">';
  			html += '<a class="controls next" href="'+ (clicked.nextImg) + '">next &raquo;</a>';
  			html += '<a class="controls previous" href="' + (clicked.prevImg) + '">&laquo; prev</a>';
  			html += '</div>';
  			$('#myModal').modal();
  			$('#myModal').on('shown.bs.modal', function(){
  					$('#myModal .modal-body').html(html);
  					showHideControls();
  			})
  			$('#myModal').on('hidden.bs.modal', function(){
  					$('#myModal .modal-body').html('');
  			});
  	}
  	function nextPrevHandler(){
  			var index = $(this).attr('href');
  			var src = $('li[data-index="'+index+'"] img').attr('src');
  			$('.modal-body img').attr('src', src);
  			clicked.prevImg = parseInt(index) - 1;
  			clicked.nextImg = parseInt(clicked.prevImg) + 2;
  			if($(this).hasClass('previous')){
  				$(this).attr('href', clicked.prevImg);
  				$('a.next').attr('href', clicked.nextImg);
  			}else{
  				$(this).attr('href', clicked.nextImg);
  				$('a.previous').attr('href', clicked.prevImg);
  			}
  		showHideControls();
  		return false;
  	}
  	function showHideControls(){
  		var total = ($('li').not('.clearfix').length);
  		if(total === clicked.nextImg){
  			$('a.next').hide();
  		}else{
  			$('a.next').show()
  		}
  		if(clicked.prevImg === -1){
  			$('a.previous').hide();
  		}else{
  			$('a.previous').show()
  		}
  	}
  	$(document).ready(function(){
  		$(this).on('click', 'a.controls', nextPrevHandler);
  		$('li').not('.clearfix').each(function(i){
  					$(this).attr('data-index',i);
  					var img = $(this).find('img');
  					img.on('click',showModal);
  		});
  	}) //end doc ready
  })();
  </script>
</head>

<body>
<div class="container-fluid">

<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8 ">
<img src="resources/img/junespreprimary-logo.png" class="img-rounded" alt="Chania" width="100%" height="30%">



<ul class="nav nav-pills nav-justified bg-info">
  <li ><a href="/">Home</a></li>
  <li ><a href="<c:url value="/aboutUs" />">About Us</a></li>
  <li class="active"><a href="#">Gallery</a></li>
      <li><a href="<c:url value="/application" />">Application</a></li>
  <li><a href="<c:url value="/contact" />">Contact</a></li>
  <li><a href="<c:url value="/login" />">Login</a></li>
</ul>


<br>

<div >
       

        <ul class="row">
            <li class="col-lg-2 col-md-3 col-sm-4 col-xs-5 col-xxs-13">
                <img class="img-responsive" src="resources/img/gallary1.jpg">
                <div class="text">Consectetur adipiscing elit</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary2.jpg">
                <div class="text">Lorem ipsum dolor sit amet, labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary3.jpg">
            </li>


            <li class="clearfix visible-xs-block"></li>


            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary4.jpg">
                <div class="text">Lorem, do eiusmod tempor incid Ut enim ad minim veniam</div>
            </li>


            <li class="clearfix visible-sm-block"></li>


            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary5.jpg">
                <div class="text">Do eiusmod tempor</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary6.jpg">
                <div class="text">Eiusmod tempor enim ad minim veniam</div>
            </li>


            <li class="clearfix visible-lg-block  visible-md-block visible-xs-block"></li>


            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider2.jpg">
                <div class="text">Adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider4.jpg">
                <div class="text">Lorem ipsum dolor sit amet, labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>


            <li class="clearfix visible-sm-block"></li>



            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider5.jpg">
                <div class="text">Eiusmod tempor enim ad minim veniam</div>
            </li>


            <li class="clearfix visible-xs-block"></li>


            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider6.jpg">
                <div class="text">Consectetur adipiscing elit</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider7.jpg">
                <div class="text">Lorem ipsum dolor sit amet, labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider8.jpg">
                <div class="text">Adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>


            <li class="clearfix visible-lg-block  visible-md-block visible-sm-block visible-xs-block"></li>


            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/slider9.jpg">
                <div class="text">Lorem ipsum dolor sit amet, labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary1.jpg">
                <div class="text">Adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam</div>
            </li>
            <li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 col-xxs-12">
                <img class="img-responsive" src="resources/img/gallary2.jpg">
                <div class="text">Consectetur adipiscing elit, re magna aliqua. Ut enim ad minim veniam</div>
            </li>


           
          </ul>
    </div> <!-- /container -->


    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-body">
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


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
