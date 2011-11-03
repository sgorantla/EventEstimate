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
function poptastic(id) {
	var url = "ClientFlowMVC?env=" + id;
	
	alert(url);
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
      <%
        String data[] = { "prod","s1","l1","f1","f2","d1" };
      
      	for (int i = 0; i < 6; i++) {
      %>	      
      		<tr>	
      		<td>
      		  <a href="javascript:poptastic('<%=data[i]%>');">Geeksquad Lists on <%=data[i] %>
      		  </a>
      		</td>
      		</tr>
      <%
      	}
      %>
    </ul>
</table>

  <div id="content">
    <c:if test="${!empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
      <h1>Woops!</h1>

      <p class="error">Your login attempt was not successful. (<%= ((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>)</p>
    </c:if>
    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>

  </div>
</div>
</body>
</html>
