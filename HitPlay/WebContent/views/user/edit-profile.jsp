<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
	<s:form action = "doEditProfile" >
		<table>
			
			<tr>
				<td>First Name</td>
				<td><s:textfield name="profileBean.firstName"  value = "%{#request.profileBean.firstName}"/></td>
			</tr>
			
			<tr>
				<td>Last Name</td>
				<td><s:textfield name="profileBean.lastName"  value = "%{#request.profileBean.lastName}"/></td>
			</tr>
			
			<tr>
				<td>Gender</td>
				<td>
					<select name = "profileBean.gender">
						<option value = 'm'   <s:if test ="%{#request.profileBean.gender == 'm'}">selected</s:if>>Male</option>
						<option value = 'f'   <s:if test ="%{#request.profileBean.gender == 'f'}">selected</s:if>>Female</option>
					</select>				
				</td>
			</tr>
				<s:submit value = "Submit"></s:submit>
			</table>
	</s:form>
</body>
</html>