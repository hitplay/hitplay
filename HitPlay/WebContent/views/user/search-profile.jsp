<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "doSearchProfile" method = "POST">
		<s:textfield name = "name" />
		<s:submit />
	</form>
	
	<s:iterator value="profiles">
		<hr>
		
		<s:url action="profile" var="profile_url">
				<s:param name="id"><s:property value="profileId"/></s:param>
		</s:url>
	
		<s:a href = "%{profile_url}"> <s:property value="firstName"/> <s:property value="lastName"/> <br/></s:a>

		<hr>
	</s:iterator>
	
	<!-- Display page index numbers, if there is an existing result list -->
	<!-- If no result list, it will evaluate to null. Hence we will not show the page index which is statically 0. -->
	<c:if test="${paginationHelperBean.number_of_pages != null && paginationHelperBean.total_count != 0}">
		<c:forEach var="pageNumber" begin="0" end="${paginationHelperBean.number_of_pages }">  
			
				<s:url action="doSearchProfile" var="next_page">
					<s:param name="name">${name}</s:param>
					<s:param name="page">${pageNumber}</s:param>
				</s:url>
				
				<s:a href = "%{next_page}">${pageNumber+1}</s:a>
		</c:forEach> 
	</c:if>
	
</body>
</html>