<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>
<body>
   <h1>MIA Login</h1>
   <form name='f' action="/SpringTest/myLogin" method='POST'>
      <table> 
   <%--    ${param.login_error} --%> 
<%--        <c:if test="${empty param.error ? 'emp o null' : 'no emp'}">ee
  			${SPRING_SECURITY_LAST_EXCEPTION.message}
		</c:if>
		 --%>
		
		<c:if test="${!empty param.error}">
		    ERRORE - ${param.error} - ${SPRING_SECURITY_LAST_EXCEPTION.message}
		</c:if>
		
		<c:if test="${!empty param.error1}">
		    ERRORE1 - ${param.error1} 
		</c:if>
      
     
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr> 
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
         
         <tr>
             <td>Remember Me:</td>
             <td><input type="checkbox" name="remember-me" /></td>
         </tr>
         
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
      </table>
  </form>
</body>
</html>