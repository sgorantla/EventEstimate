<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <link href="<c:url value="/main.css"/>" rel="stylesheet" type="text/css"/>
  <title>I'm going to redirect once I get the application id from the controller...</title>
<script type=javascript>
<%

URL here = new URL(request.getRequestURL().toString());

String userName = request.getParameter("userName");
String callback = here.getProtocol() + "://" + here.getHost() + (here.getDefaultPort() != here.getPort() && here.getPort() > 0 ? ":" + here.getPort() : "") + "/cf_redir_page.jsp?userName=" + userName;

String url = new String("https://oauth2.constantcontact.com/oauth2/oauth/siteowner/authorize?client_id=" + request.getAttribute("appId") + "&response_type=token&redirect_uri=" + URLEncoder.encode(callback));
%>
</head>
</script>
<body>
<%
response.sendRedirect(url);
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
</body>
</html>
