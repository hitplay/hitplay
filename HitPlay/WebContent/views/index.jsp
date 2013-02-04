<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<jsp:include page="inits/initHead.jsp" />
<script>
$(document).ready(function() {
	"user strict"
	$('a').each(function(index,value){
		  var page = $(this).attr("href");
		  var hash  = "#";
		  $(this).attr("href",hash+page);
	});
	
	$('#submit-login').on('click',function(e){
			$('#hidden-submit-login').click();
	})
	
		$('body').on('submit','#sign-in', function(e) {
			e.preventDefault();
					
			var data = $(this).serialize();

			var url = $(this).attr('action');
			$.ajax({
				url : url,
				type : "POST",
				data : data,
				
				//Do not cache the page
				cache : false,
				//success
				dataType: "html",
				success : function(response,status) {
					
					//Results for successful login page
					
					//If the user has valid credentials, it will return a dashboard html page.
					if(!(typeof $(response).find('#dashboard').html() === 'undefined')){
						$('#loginModal').modal("hide");
						$('#wrap').html('');
						$('#wrap').html( $(response).find('#dashboard').html() );
					}else{
						//If the user Entered Invalid Credntials, it will just return the 
						//loginModal Page response from the server
						$('#sign-in').html($(response).find('#sign-in').html());
					}
					
					/*
					//If the User is Successfully logged it, it will reutnr the dashboard page
					 var dashboard= $(response).filter('#dashboard');				 
					 //This Will Return the LoginModal If The user has invalid credentials
					 var loginModal = $(response).find('#loginModal').html();
					 $('#loginModal').html(loginModal);
					 
					 if(dashboard.length != 0){
						 alert("XD");
					 }else{
						 alert("FAIL TO LOGIN");
					 }
					 */
				}
			});
		});
});

</script>
<style type="text/css">
      
      body {
       	paddding-top:40px;
       	padding-bottom:40px;
      }
    
    </style>
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="ico/favicon.ico">
  </head>

  <body>
  <div id="wrap">


    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.html">HitPlay</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Discover<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="searchbyartist.html">by Artist</a></li>
                  <li><a href="searchbygenre.html">by Genre</a></li>
                </ul>
              </li>


              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
            <form class="navbar-form pull-right">

              <a href="#signupModal" class="btn btn-primary" data-toggle="modal">Sign up &rsaquo;&rsaquo;</a>
              <a href="#loginModal" class="btn btn-success" data-toggle="modal">Login &rsaquo;&rsaquo;</a>
            </form>

          </div><!--/.nav-collapse -->
        </div>
      </div>

      <div class="ygreen-accent"></div>
    </div>

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="img/slider/img1.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>HitPlay.</h1>
              <p class="lead">Bleh bleh bleh</p>
              <a href="#signupModal" class="btn btn-large btn-primary" data-toggle="modal">Sign up &rsaquo;&rsaquo;</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/slider/img2.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>Why HitPlay?</h1>
              <p class="lead">Bleh bleh bleh</p>
              <a href="#signupModal" class="btn btn-large btn-primary" data-toggle="modal">Sign up &rsaquo;&rsaquo;</a>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img/slider/img3.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
              <h1>More on HitPlay.</h1>
              <p class="lead">Bleh bleh bleh</p>
              <a href="#signupModal" class="btn btn-large btn-primary" data-toggle="modal">Sign up &rsaquo;&rsaquo;</a>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->


    <!--Hidden Signup Modal-->
    
    <div id="signupModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Sign Up</h3>
      </div>

      <div class="modal-body"><!--Modal Body === Form -->
          <form class="contact_form" action="doLogin" method="post" name="contact_form">
              <ul>
                  <li>
                    
                  </li>
                  <li>
                      <label for="name">* Username:</label>
                      <input type="text"  placeholder="User123" required />
                      <span class="form_hint">sNo spaces and special characters allowed</span>
                  </li>
                  <li>
                      <label for="email">* Email:</label>
                      <input type="email" name="email" placeholder="user123@example.com" required />
                      <span class="form_hint">Proper format "name@something.com"</span>
                  </li>
                  <li>
                      <label for="website">* Password:</label>
                      <input type="password" name="password" placeholder="********" required />
                      <span class="form_hint">Minimum of 4 characters</span>
                  </li>
                  <li>
                      <label for="website">* Confirm Password:</label>
                      <input type="password" name="password" placeholder="********" required />
                      <span class="form_hint">Repeat Password</span>
                  </li> 
                   <li>
                      <label for="website">* Date Of Birth:</label>
                      <input type="text" name="password" placeholder="mm/dd/yyyy" required />
                      <span class="form_hint">12/31/1992</span>                  
              </ul>
      </div>

		      <div class="modal-footer">
		        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
		        <button class="submit" type="submit">Submit Form</button>
		      </div>
     </form>
    </div><!--end signup modal-->
	


     <!--Hidden Login Modal-->
     
    <div id="loginModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Login</h3>
      </div>

      <div class="modal-body" id = "modal-body-sign-in"><!--Modal Body === Form -->
          <form class="contact_form" id = "sign-in" action="doLogin" method="post" name="contact_form">
              <ul>                  
                  <li>
                      <label for="email">Username:</label>
                      <input type="textfield" name="userBean.username" placeholder="user123@example.com" required />
                      <span class="form_hint">Proper format "name@something.com"</span>
                  </li>
                  <li>
                      <label for="website">Password:</label>
                      <input type="password" name="userBean.password" placeholder="********" required />
                      <span class="form_hint">Minimum of 9 characters</span>
                  </li>
              </ul>
             <button type = "submit" id = "hidden-submit-login" hidden = "true">kk</button>
            </form>
      </div>

	      <div class="modal-footer">
	        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	        <button class="submit" id = "submit-login"type="submit">Login</button>
	      </div>
    </div>


    <div class="container">

      <!-- row of columns -->
          <ul class="thumbnails">
            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Latest Artist</h2>
                <h5><a href="#">Learn</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>
            
            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Share</h2>
                <h5><a href="#">Share Your Music Creation</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>

            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Discover</h2>Promote Your Creations</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>
          </ul>
      <hr>
  	</div><!--wrap end-->
</div> <!-- /container -->
<!--footer-->
      <div class="navbar navbar-inverse navbar-fixed-bottom">

        <div class="navbar-inner">
          <div class="container">

            <div align="center">
              <audio id="player2" src="music.mp3" type="audio/mp3" controls="controls"></audio>  

              <script>
                $('audio').mediaelementplayer({audioWidth: 960, audioHeight: 30, features: ['playpause','progress','current','duration','tracks','volume','fullscreen']});
              </script>
          </div>
        </div>
      </div>
    </div>

    
	<jsp:include page="inits/initBot.jsp" />
  </body>
</html>