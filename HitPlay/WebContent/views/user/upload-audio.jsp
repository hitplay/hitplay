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

	<s:form action="doUploadAudio" namespace="/" method="POST"
		enctype="multipart/form-data">

		<s:textfield name="title" />
		<s:textfield name="filename" />
		<s:file name="file" id="fileup" value="kyel" label="File" />
		<s:fielderror />
		<s:submit id="upload-file" />

	</s:form>

</body>
</html>