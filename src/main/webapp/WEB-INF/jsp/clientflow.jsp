<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>I'm going to redirect once I get the application id from the controller...</title>
<script type=javascript>
<%
String environment = new String(request.getParameter("env"));
String envParam = environment;
if (environment.equalsIgnoreCase("prod"))
	environment = ".";
else
	environment = "." + environment + ".";

String url = new String("https://oauth2" + environment + 
		"constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=" + request.getAttribute("appId") +
		"&response_type=token&redirect_uri=" +
		URLEncoder.encode("http://localhost:9999/ctctOAuth2WebClient/cf_redir_page.jsp?env=" + envParam));
%>
</head>
</script>
<body>
<%
response.sendRedirect(url);
%>
</body>
</html>
