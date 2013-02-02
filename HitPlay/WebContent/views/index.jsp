<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--  Style Sheets -->

<link href="${contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/css/sticky_footer.css" rel="stylesheet">
<link href="${contextPath}/css/carousel.css" rel="stylesheet">
<link href="${contextPath}/css/mycustom.css" rel="stylesheet">
<link href="${contextPath}/css/web-serveroff-fontfacekit/stylesheet.css" rel="stylesheet">
<link href="${contextPath}/css/open-sans-fontfacekit/stylesheet.css" rel="stylesheet">


<!--  The Grand Daddy of them all -->
<script src="http://code.jquery.com/jquery-1.9.0.min.js"></script>

<!--  Other Necessary Scripts and CSS -->
<script src="${contextPath}/javascripts/mediaelement/mediaelement-and-player.min.js"></script>
<link rel="stylesheet" href="${contextPath}/javascripts/mediaelement/c_mediaelementplayer.css" />


<!-- Ajax Stuff -->
<script src="${contextPath}/javascripts/jquery-bbq.js"></script>
<script	src="${contextPath}/javascripts/ajaxified.js"></script>
<script src="${contextPath}/javascripts/holder/holders.js"></script>

<link href="${contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
<script>
$(document).ready(function() {
	$('a').each(function(index,value){
		  var page = $(this).attr("href");
		  var hash  = "#";
		  $(this).attr("href",hash+page);
	});

		$('#modal-body-sign-in').on('submit', '#sign-in', function(e) {
			e.preventDefault();
			var data = $(this).serialize();
			var url = $(this).attr('action');
			$.ajax({
				//this is the php file that processes the data and send mail
				url : url,
				type : "POST",
				data : data,
				dataType: "html",
				//Do not cache the page
				cache : false,
				//success
				success : function(data) {
					//console.log(data.content);
					
					console.log($(data));
				//$('#modal-body-sign-in').html($(html).find('#modal-body').html());
				}
			});
		})
   

});

</script>
<style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
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
                      <span class="required_notification">* Invalid user name or password</span>
                  </li>
                  <li>
                      <label for="name">* Username:</label>
                      <input type="text"  placeholder="User123" required />
                      <span class="form_hint">No spaces and special characters allowed</span>
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
      </div>

	      <div class="modal-footer">
	        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	        <button class="submit" type="submit">Login</button>
	      </div>
       </form>
       
    </div>

    <div class="container">

      <!-- row of columns -->

          <ul class="thumbnails">
            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Latest Artist</h2>
                <h5><a href="#">Artist Name</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>

            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Popular Song</h2>
                <h5><a href="#">Song Title by Artist Name</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>

            <li class="span4">
              <div class="thumbnail">
                <img data-src="holder.js/300x200" alt="">
                <h2>Latest Upload</h2>
                <h5><a href="#">Song Title by Artist Name</a></h5>
                <div class="media-body">
                  <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet fermentum.</p>
                </div>
              </div>
            </li>
          </ul>
      <hr>
  </div><!--wrap end-->

<!--footer-->
      <div class="navbar navbar-inverse navbar-fixed-bottom">

        <div class="navbar-inner">
          <div class="container">

            <div align="center">
              <audio id="player2" src="media/Banana_boat_song.mp3" type="audio/mp3" controls="controls"></audio>  

              <script>
                $('audio,video').mediaelementplayer({audioWidth: 960, audioHeight: 30, features: ['playpause','progress','current','duration','tracks','volume','fullscreen']});
              </script>

          </div>
        </div>
      </div>
    </div>

    </div> <!-- /container -->
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-transition.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-alert.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-modal.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-dropdown.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-scrollspy.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-tab.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-tooltip.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-popover.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-button.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-collapse.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-carousel.js"></script>
    <script src="${contextPath}/javascripts/bootstrap/bootstrap-typeahead.js"></script>

  </body>
</html>