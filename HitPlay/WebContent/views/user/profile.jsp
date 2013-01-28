<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<h1>${profile.firstName}</h1>
<img src="${profile.picture.picturePath}" height= "160" width ="160" />
<table>
	<tr>
		<td>First Name</td>
		<td>${profile.firstName}</td>
	</tr>
	
	<tr>
		<td>Last Name</td>
		<td>${profile.lastName}</td>
	</tr>

	<tr>
		<td>Gender</td>
		<td>${profile.gender}</td>
	</tr>
	
	<tr>
		<td>Age</td>
		<td>${profile.age}</td>
	</tr>
</table>
</body>
</html>