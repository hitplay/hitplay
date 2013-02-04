<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>

<link href="${contextPath}/css/animate-custom.css" rel="stylesheet">

</head>
<body>
	<div id="wrap">
		<div id="dashboard" class = "animated fadeInDown">
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container">
						<a class="btn btn-navbar" data-toggle="collapse"
							data-target=".nav-collapse"> <span class="icon-bar"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span>
						</a> <a class="brand active" href="index.html">HitPlay</a>
						<div class="nav-collapse collapse">
							<ul class="nav">
								<li class="active"><a href="dashboard.html">Dashboard</a></li>

								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Discover<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="searchbyartist.html">by Artist</a></li>
										<li><a href="searchbygenre.html">by Genre</a></li>
									</ul></li>

								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Songs<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="upload.html">Upload Song</a></li>
									</ul></li>

								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Welcome ${sessionScope.user_username}<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="profile.html">My Profile</a></li>
										<li class="divider"></li>
										<li class="nav-header">Settings</li>
										<li><a href="accountsettings.html">Account Settings</a></li>
										<li><a href="profilesettings.html">Profile Settings</a></li>
										<li class="divider"></li>
										<li><a href="#">Logout</a></li>
									</ul></li>
							</ul>

							<form class="navbar-form pull-right">
								<input type="text" class="input-large">
								<button type="submit" class="submit">Search</button>
							</form>

						</div>
						<!--/.nav-collapse -->
					</div>
				</div>

				<div class="ygreen-accent"></div>
			</div>



			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3" style = "padding-top: 80px">
						<div class="well sidebar-nav">
							<ul class="nav nav-list">
								<li class="nav-header">Personal</li>
								<li class="#"><a href="dummy2.html" target="ifrim">Home</a></li>
								<li><a href="profile.html">My Profile</a></li>
								<li><a href="#"></a></li>
								<li><a href="accountsettings.html">Account Settings</a></li>
								<li class="nav-header">Discover</li>
								<li><a href="#">Genre</a></li>
								<li><a href="#">Bands/Artists</a></li>
								<li><a href="#">Featured</a></li>
								<li><a href="#">Most Played</a></li>
								<li><a href="#">Recent Uploads</a></li>
								<!--               <li><a href="#">Link</a></li> -->
								<li class="nav-header">News</li>
								<li><a href="dummy1.html" target="ifrim">Events</a></li>
							</ul>
						</div>
						<!--/.well -->
					</div>
					<!--/span-->
					<!-- ===================================================        -->
					<!--iframe  -->
					<div class="span9">
						<iframe name="ifrim" width="100%" height="540px"
							src="http://www.yahoo.com" frameborder="no" scrolling="auto">
						</iframe>
					</div>


				</div>
			</div>
			<!--/.fluid-container-->
		</div>
		<!--End DashBoard -->
	</div>
	<!--End Wrap -->

</body>
</html>