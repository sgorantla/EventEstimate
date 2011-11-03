<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<authz:authorize ifAllGranted="ROLE_USER">
  <c:redirect url="index.jsp"/>
</authz:authorize>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>OAUTH 2 Implicit Grant (Client Flow) Example 1</title>
 
<script type="text/javascript">
function poptastic(id,env) {
	var envParam = env;
	if (env == "prod")
		env = '.';
	else
		env = "." + env + ".";
	
	var url = "https://oauth2" + env + "constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=" + id
				+ "&response_type=token&redirect_uri="  +
				<%= "\"" + URLEncoder.encode("http://localhost:9999/ctctOAuth2WebClient/cf_redir_page.jsp?env=") + "\""%>  + envParam;
	
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
        String data[][] = { {"prod","5204d963-d686-4696-bc20-c444c23c0b33"} ,
    	  					{"s1","0700b68f-af14-42be-94b9-8ae36f10f990"} ,
    	  					{"l1","2ef92d12-c13c-4467-b90d-d1822eb32e43"} ,
    	  					{"f1","74ed0005-a09f-4cf6-8df8-70135a7ed9d4"} ,
    	  					{"f2","b4fc79f6-870b-49b7-81ad-faaae4a978cd"} ,
    	  					{"d1","145d3f5b-387d-4ff6-a25a-734477270dd6"} };
      
      	for (int i = 0; i < 6; i++) {
      %>	      
      		<tr>	
      		<td>
      		  <a href="javascript:poptastic('<%=data[i][1]%>','<%=data[i][0]%>');">Geeksquad Lists on <%=data[i][0] %></a>
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
