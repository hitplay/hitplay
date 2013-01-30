<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.min.js"></script>

<script
	src="${pageContext.request.contextPath}/javascripts/tagit/tag-it.js"></script>

<link
	href="${pageContext.request.contextPath}/stylesheets/tagit/jquery.tagit.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/stylesheets/tagit/tagit.ui-zendesk.css"
	rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>

	<s:form action="doUploadAudio" namespace="/" method="POST"
		enctype="multipart/form-data">

		<table>
			<tr>
				<td>Title</td>
				<td><s:textfield name="audioBean.title" /></td>
			</tr>
			<tr>
				<td>Artist</td>
				<td><s:textfield name="audioBean.artist" /></td>
			</tr>
			<tr>
				<td>Genre</td>
				<td><select name="genreId">
						<s:iterator value="genres" var ="genre">

							<option value="<s:property value = "#genre.id"/>">
								<s:property value="#genre.name" />
							</option>

						</s:iterator>
				</select></td>
			</tr>
			<tr>
				<td><s:file name="file" id="fileup" value="kyel" label="File" />
					<s:fielderror /></td>
				<td><s:submit id="upload-file" /></td>
			</tr>
		</table>

	</s:form>

</body>
</html>