<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<td>
				Welcome admin
			</td>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER')">
			<td>
				Welcome user
			</td>
		</sec:authorize>
	</tr>
</table>

Welcome
</body>
</html>