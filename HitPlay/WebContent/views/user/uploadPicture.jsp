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

	<s:form action="doUploadPicture" namespace="/" method="POST"
		enctype="multipart/form-data">

		<table>
			<tr>
				<td>Upload File:</td>
				<td><s:file name="userImage" label="Select a File to upload"
						size="40" /></td>
			</tr>

			<tr>
				<td>Image Description:</td>
				<td><s:textfield name="pictureBean.pictureDescription" /></td>
			</tr>

			<tr>
				<td></td>
				<td><s:submit value="Submit"></s:submit></td>
			</tr>
		</table>

	</s:form>

</body>
</html>