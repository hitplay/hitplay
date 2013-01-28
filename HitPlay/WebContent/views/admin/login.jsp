<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
ul {
	margin: 0%;
}

ul li {
	display: inline;
	list-style-type: none;
	float: left;
}
</style>
<title>Admin Panel</title>
</head>
<body>
	<h1>Admin Panel</h1>
	<!--  Ajax Container. DO NOT REMOVE THE DIV CONTENT  FOR AJAX ACCESS! -->
	<div id="content">
		<div id="login-form">			
			<s:form action="doLogin" namespace = "/admin">
				<fieldset>
				<s:actionerror/>
				<s:fielderror><s:param>adminBean.password</s:param></s:fielderror><br/>			
				<s:fielderror><s:param>adminBean.username</s:param></s:fielderror>					
				<br/>
					<label>Username</label>					
					<s:textfield name="adminBean.username" value="" />
					<br/>
					<label>Password</label>
					<s:password name="adminBean.password" value=""/>
					<br />
					<%-- <s:hidden name="fromForm" value="true"/> --%>
					<s:submit />
				</fieldset>
			</s:form>

		</div>

	</div>
</body>
</html>