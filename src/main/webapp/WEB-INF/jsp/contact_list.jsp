<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Customer Map</title>
</head>
<body>
<table>
<c:forEach var="contact" items="${contacts}" varStatus="loopStatus">
        <tr>
            <td>
                ${contact.emailAddress}
            </td>
            <td>
                ${contact.addr1}
            </td>
            <td>
                ${contact.city}
            </td>

        </tr>
</c:forEach>
</table>

</body>
</html>
