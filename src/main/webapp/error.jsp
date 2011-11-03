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
  <title>error</title>
</head>
<body>
<div id="container">

    <ul id="mainlinks">
      <li><a href="<c:url value="/sparklr/list?resource=ggvm"/>">ggVM lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=d1"/>">d1 lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=l1"/>">l1 lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=f1"/>">f1 lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=f2"/>">f2 lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=s1"/>">s1 lists</a></li>
      <li><a href="<c:url value="/sparklr/list?resource=prod"/>">production lists</a></li>
    </ul>

  <div id="content">
    <c:if test="${!empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION}">
      <h1>Woops!</h1>

      <p class="error">Your login attempt was not successful. Exception: 
     (<%= session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY).getClass().getName() %>)<br>:
     (<%= ((AuthenticationException) session.getAttribute(AbstractAuthenticationProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>)</p>
    </c:if>
    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
   </div>
</div>
</body>
</html>
