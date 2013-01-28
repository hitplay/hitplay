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
	<h1>Welcome ${user_username}</h1>


	<!-- The URLS that are going to be used  -->

	<s:url value="profile" var="profile_url">
		<s:param name="id">${user_id}</s:param>
	</s:url>

	<s:url value="editProfile" var="edit_profile_url"></s:url>
	<s:url value="uploadPicture" var="upload_picture"></s:url>
	<s:url value="searchProfile" var="search_profile"></s:url>
	<s:url value="uploadTrack" var="upload_track"></s:url>
	<s:url value="doLogout" var="logout"></s:url>

	<s:a href="%{profile_url}">My Profile</s:a>
	<s:a href="%{edit_profile_url}">Edit Profile</s:a>
	<s:a href="%{upload_picture}">Upload Picture</s:a>
	<s:a href="%{search_profile}">Search Profile</s:a>
	<s:a href="%{upload_track}">Upload Track</s:a>
	<s:a href="%{logout}">logout</s:a>

</body>
</html>