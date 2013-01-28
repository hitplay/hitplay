<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form action  = "addGenre" namespace = "/admin">
		<label>Genre Name</label>
		<s:textfield name = "genreBean.name" /><br/>
		<label>Genre Description</label>
		<s:textarea name="genreBean.description" cols="10" rows="10"/>
		<s:submit value = "Submit" />
	</s:form>
</body>
</html>