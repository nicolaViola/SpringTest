<html>
<head></head>
<body>
   <h1>MIA Login</h1>
   <form name='f' action="/SpringTest/myLogin" method='POST'>
      <table>
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
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
      </table>
  </form>
</body>
</html>