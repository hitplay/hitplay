<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Admin Control Panel </h1>
</body>

	<s:url action = "newTag" var = "newTag_url"> </s:url>
	<s:url action = "newGenre" var = "newGenre_url"> </s:url>
	
	<s:a href = "%{newTag_url}">New Tag </s:a>
	<s:a href = "%{newGenre_url}">New Genre </s:a>
</html>