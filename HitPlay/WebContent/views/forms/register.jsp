<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
ul {
	margin: 0%;
	float:left;
}

ul li {
	display: inline;
	list-style-type: none;
	float: left;
}
</style>
</head>
<body>
	<!--  Ajax Container. DO NOT REMOVE THE DIV CONTENT  FOR AJAX ACCESS! -->
	<div id="content">
	
	<div id = "reg-form">
		<s:form action="doRegister">
			<p>Fields with * are required</p>
			<h5>Account Information</h5>
				<s:fielderror>
					<s:param>usernameError</s:param><br />
					<s:param>emailError</s:param><br />
				</s:fielderror>
				<fieldset>
				<label>Username</label><s:fielderror><s:param>userBean.username</s:param></s:fielderror>
				<s:textfield name="userBean.username" /><br />
				<label>Password</label><s:fielderror><s:param>userBean.password</s:param></s:fielderror>
				<s:password name="userBean.password" /><br />
				<label>Retype Password</label>
				<s:password name="temp_pass" /><br />
				<label>Email</label><s:fielderror><s:param>userBean.email</s:param></s:fielderror>
				<s:textfield name="userBean.email" /><br />
				<br />
			</fieldset>
			
			<h5>Personal Information</h5>
				<fieldset>
				<label>First Name</label>
				<s:textfield name="profileBean.firstName" /><br />
				<label>Last Name</label>
				<s:textfield name="profileBean.lastName" /><br />		
				<label>Gender</label>
				<s:select name = "profileBean.gender" list = "#{'m':'Male','f': 'Female'}"/><br/>				
				<label>Birth Day</label><s:fielderror><s:param>birthDay</s:param></s:fielderror>
				<s:textfield name = "birthDay"/><br/>				
			</fieldset>	
			<s:submit />
		</s:form>
	
	</div>
	</div>
</body>
</html>