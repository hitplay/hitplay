<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery.min.js"></script>
<script src = "${pageContext.request.contextPath}/javascripts/jquery-bbq.js"></script>
<script src = "${pageContext.request.contextPath}/javascripts/ajaxified.js"></script>
<script>
$(document).ready(function() {
	$('a').each(function(index,value){
		  var page = $(this).attr("href");
		  var hash  = "#";
		  $(this).attr("href",hash+page);
	});
});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>Tayo na at mag Cha Cha!!</h1>
</body>

	<s:url value="register" var="register_url">
	</s:url>

	<s:url value ="login" var="login_url" >
	</s:url>

	<div class="bbq-content">
		
	</div>
	
	<s:a href="%{register_url}">Register</s:a>

	<s:a href="%{login_url}">login</s:a>
	

</html>