<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
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
		
		<td align="right">
			<%-- <a href="<c:url value="/logout" />">Logout</a> --%>
			<form name='f' action="/SpringTest/logout" method='POST'>
				 <td><input name="submit" type="submit" value="submit" /></td>
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			 </form>
		</td>
	</tr>
</table>

Welcome
</body>
</html>