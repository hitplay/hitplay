<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
</head>
<body>

	<div id = "div1">
		<h1>HI am a dashboard</h1>
		<h1>HI am a dashboard</h1>
		<h1>HI am a dashboard</h1>
	</div>

	<!--  Ajax ontainer. DO NOT REMOVE THE DIV CONTENT  FOR AJAX ACCESS! -->
	<% if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){ %>
	<div id="loginModalContainer">
		<div id="loginModal" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<script>
     		location.reload();
     	</script>
		</div>
	</div>
	<% } %>

</body>
</html>