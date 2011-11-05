<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<authz:authorize ifAllGranted="ROLE_USER">
  <c:redirect url="index.jsp"/>
</authz:authorize>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>OAUTH 2 Implicit Grant (Client Flow) Example 2 (using MVC)</title>

<script type="text/javascript">
function poptastic() {
    var userName = document.getElementById("userName").value;
    if (!userName) {
        alert("please enter name");
        return false;
    }
	var url = "clientflow/tab?userName="+userName;
	
	if (window.location.hash.length == 0) {
		window.open(url, 'name');
	}
}
</script>  
  
</head>
<body>
<div id="container">
<table>
    <ul id="mainlinks">
        <tr>
             <td>
                 <label for="userName">User Name:</label>  <input type="text" name="userName" id="userName" maxlength="50" />
        </td>
        </tr>
      		<tr>
      		<td>
                  <button name="getContacts" onclick="poptastic(); return false;">Find Contacts</button>
      		</td>
      		</tr>
    </ul>
</table>

</div>
</body>
</html>
